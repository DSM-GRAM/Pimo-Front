package gram.com.pimo.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.baoyz.swipemenulistview.SwipeMenu
import com.baoyz.swipemenulistview.SwipeMenuItem
import com.baoyz.swipemenulistview.SwipeMenuListView
import gram.com.pimo.Connector.Connector
import gram.com.pimo.Model.MemoModel
import gram.com.pimo.R
import gram.com.pimo.Util.BaseActivity
import io.realm.RealmResults
import kotlinx.android.synthetic.main.memo_main.*
import kotlinx.android.synthetic.main.memolist_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by root1 on 2017. 11. 12..
 */

class MemoListActivity: BaseActivity(){

    var dataArr : RealmResults<MemoModel>? = null
    val adapter = MemoListAdapter()

    fun bind(){
        val data = getRealm().where(MemoModel::class.java).findAll()
        adapter.bind(data)
    }

    fun setListView(){

        listView.adapter = adapter
        bind()

        listView.setMenuCreator {
            menu ->
            val deleteItem = SwipeMenuItem(this)
            deleteItem.setBackground(Color.RED)
            deleteItem.width = 90
            deleteItem.setIcon(R.drawable.icon_delete)
            menu.addMenuItem(deleteItem)
        }

        listView.setOnItemClickListener { _, _, pos, _ ->
            val selectData = dataArr?.get(pos)
            val intent = Intent(this, MemoWriteActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("data", selectData)
            intent.putExtras(bundle)
            startActivity(intent)
        }


        listView.setOnMenuItemClickListener(object : SwipeMenuListView.OnMenuItemClickListener {
            override fun onMenuItemClick(position: Int, menu: SwipeMenu?, index: Int): Boolean {
                if(index == 0){
                    Connector.api?.deleteMemo(getToken(), dataArr!!.get(position).id)?.enqueue(object : Callback<Void>{
                        override fun onFailure(call: Call<Void>?, t: Throwable?) {
                            t?.printStackTrace()
                        }

                        override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                            if(response?.code() == 201){
                                getRealm().executeTransaction {
                                    realm ->
                                    dataArr!!.get(position).deleteFromRealm()
                                }

                                bind()
                            }else{
                                showToast("삭제를 실패했습니다.")
                            }
                        }
                    })

                }

                return false
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Connector.api?.loadMemo(getToken())?.enqueue(object : Callback<Array<MemoModel>>{
            override fun onResponse(call: Call<Array<MemoModel>>?, response: Response<Array<MemoModel>>?) {
                if(response?.code() == 200){

                    getRealm().executeTransaction {
                        realm ->
                        realm.deleteAll()
                    }

                    getRealm().executeTransaction {
                        realm ->
                        for(memo in response?.body()!!) {
                            realm.copyFromRealm(memo)
                        }
                    }

                    bind()

                }else{
                    showToast("데이터 로드 실패")
                }
            }

            override fun onFailure(call: Call<Array<MemoModel>>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

        write_memo.setOnClickListener {

        }

        setListView()
    }
}

class MemoListAdapter: BaseAdapter(){

    var data : RealmResults<MemoModel>? = null

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(p2?.context).inflate(R.layout.memolist_item, null)
        val setData = data!!.get(p0)
        with(view){
            title_text.text = setData.title
            content_text.text = setData.content
        }

        return view
    }

    fun bind(data: RealmResults<MemoModel>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItem(p0: Int): Any {
        return data!!.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        if(data == null){
            return 0
        }else{
            return data!!.size
        }
    }

}