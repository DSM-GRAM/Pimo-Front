package gram.com.pimo.Activity

import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import gram.com.pimo.Connector.Connector
import gram.com.pimo.Model.MemoModel
import gram.com.pimo.R
import gram.com.pimo.Util.BaseActivity
import kotlinx.android.synthetic.main.memocomplete.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by root1 on 2017. 11. 14..
 */
class MemoCompleteActivity: BaseActivity() {

    lateinit var mapFragment: MapFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memocomplete)

        mapFragment = MapFragment.newInstance()
        val ft = fragmentManager.beginTransaction()
        ft.add(R.id.map, mapFragment)
        ft.commit()

        val data = intent.getSerializableExtra("data") as MemoModel

        val laLong = LatLng(data.lati, data.longi)

        mapFragment.getMapAsync(object : OnMapReadyCallback{
            override fun onMapReady(map: GoogleMap) {
                map.addMarker(MarkerOptions().position(laLong))
                map.moveCamera(CameraUpdateFactory.newLatLng(laLong))
            }
        })

        button_complete.setOnClickListener {
            if(data.id.isEmpty()){
                Connector.api?.addMemo(getToken(), data.title, data.content, data.lati, data.longi)
                        ?.enqueue(object : Callback<MemoModel> {
                            override fun onFailure(call: Call<MemoModel>?, t: Throwable?) {
                                t?.printStackTrace()
                            }

                            override fun onResponse(call: Call<MemoModel>?, response: Response<MemoModel>?) {
                                if (response?.code() == 201){
                                    getRealm().executeTransaction {
                                        realm ->
                                        realm.copyFromRealm(response.body()!!)
                                        finish()
                                    }
                                }
                            }
                        })
            }else{
                Connector.api?.updateMemo(getToken(),data.id,  data.title, data.content, data.lati, data.longi)
                        ?.enqueue(object : Callback<MemoModel> {
                            override fun onFailure(call: Call<MemoModel>?, t: Throwable?) {
                                t?.printStackTrace()
                            }

                            override fun onResponse(call: Call<MemoModel>?, response: Response<MemoModel>?) {
                                if (response?.code() == 201){
                                    getRealm().executeTransaction {
                                        realm ->
                                        realm.where(MemoModel::class.java).equalTo("_id", data.id).findFirst().deleteFromRealm()
                                        realm.copyFromRealm(response.body()!!)
                                        finish()
                                    }
                                }
                            }
                        })
            }
        }

    }
}