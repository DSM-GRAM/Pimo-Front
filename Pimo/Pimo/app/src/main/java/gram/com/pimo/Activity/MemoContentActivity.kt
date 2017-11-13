package gram.com.pimo.Activity

import android.content.Intent
import android.os.Bundle
import gram.com.pimo.Model.MemoModel
import gram.com.pimo.R
import gram.com.pimo.Util.BaseActivity
import kotlinx.android.synthetic.main.memo.*

/**
 * Created by root1 on 2017. 11. 13..
 */

class MemoContentActivity: BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memo)


        val data = intent.getSerializableExtra("data") as MemoModel

        text_modified.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()
            bundle.putSerializable("data", data)
            startActivity(intent)
        }

        text_memo.text = data.title
        text_contents.text = data.content
        text_location.text = "위치 : ${data.address}"

    }

}