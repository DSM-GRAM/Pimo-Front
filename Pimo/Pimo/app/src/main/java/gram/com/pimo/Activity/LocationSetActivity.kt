package gram.com.pimo.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gram.com.pimo.Connector.Connector
import gram.com.pimo.Model.LocationListModel
import gram.com.pimo.Model.MemoModel
import gram.com.pimo.R
import gram.com.pimo.Util.BaseActivity
import kotlinx.android.synthetic.main.searchlocation.*
import kotlinx.android.synthetic.main.searchlocation_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by root1 on 2017. 11. 14..
 */
class LocationSetActivity: BaseActivity() {

    val adapter = LocationSetAdapter(this)
    var activity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchlocation)

        val getData = intent.getSerializableExtra("data") as MemoModel

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        find_button.setOnClickListener {
            if(loc_edit.text.toString().isEmpty()){

            }else{
                Connector.api?.searchLocation(loc_edit.text.toString())?.enqueue(object : Callback<Array<LocationListModel>>{
                    override fun onFailure(call: Call<Array<LocationListModel>>?, t: Throwable?) {
                        t?.printStackTrace()
                    }

                    override fun onResponse(call: Call<Array<LocationListModel>>?, response: Response<Array<LocationListModel>>?) {
                        if(response?.code() == 200){
                            adapter.bind(response.body()!!, getData)
                        }else{
                            showToast("불러오기 오류")
                        }
                    }
                })
            }
        }

    }

}

class LocationSetAdapter(activity: BaseActivity): RecyclerView.Adapter<LocationViewHolder>() {

    lateinit var activity: BaseActivity

    init {
        this.activity = activity
    }

    var data = emptyArray<LocationListModel>()
    var sendData = MemoModel()

    fun bind(data: Array<LocationListModel>, sendData: MemoModel){
        this.data = data
        this.sendData = sendData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.searchlocation_item, null)
        return LocationViewHolder(view, sendData, activity)
    }

    override fun onBindViewHolder(holder: LocationViewHolder?, position: Int) {
        holder?.bind(data.get(position))
    }
}

class LocationViewHolder(view: View, sendData: MemoModel, activity: BaseActivity): RecyclerView.ViewHolder(view){

    lateinit var view: View
    lateinit var sendData: MemoModel
    lateinit var activity: BaseActivity

    init {
        this.view = view
        this.sendData = sendData
        this.activity = activity
    }

    fun bind(data: LocationListModel){
        with(view){
            id_text.setText(data.name)
        }

        view.setOnClickListener {
            val intent = Intent(activity, MemoCompleteActivity::class.java)
            val bundle = Bundle()
            sendData.lati = data.lati
            sendData.longi = data.longi
            Log.e("xxx", "${data.lati} ${data.longi}")
            bundle.putSerializable("data", sendData)
            intent.putExtras(bundle)
            activity.startActivity(intent)
            activity.finish()
        }
    }

}