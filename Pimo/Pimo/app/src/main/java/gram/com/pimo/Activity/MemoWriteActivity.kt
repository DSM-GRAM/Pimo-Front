package gram.com.pimo.Activity

import android.content.Intent
import android.os.Bundle
import gram.com.pimo.Model.MemoModel
import gram.com.pimo.R
import gram.com.pimo.Util.BaseActivity
import kotlinx.android.synthetic.main.memowrite.*

/**
 * Created by root1 on 2017. 11. 12..
 */
class MemoWriteActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.memowrite)

        val data = intent.extras?.getSerializable("data") as? MemoModel

        data?.let {
            edit_title_text.setText(data.title)
            edit_maintext.setText(data.content)
        }

        Button_gps.setOnClickListener {
            val intent = Intent(this, LocationSetActivity::class.java)
            val bundle = Bundle()

            if(data == null){
                val createData = MemoModel()
                createData.title = edit_title_text.text.toString()
                createData.content = edit_maintext.text.toString()
                bundle.putSerializable("data", createData)
            }else{
                data?.title = edit_title_text.text.toString()
                data?.content = edit_maintext.text.toString()
                bundle.putSerializable("data", data)
            }

            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }

    }


}