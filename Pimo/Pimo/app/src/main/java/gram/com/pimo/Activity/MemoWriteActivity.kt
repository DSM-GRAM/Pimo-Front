package gram.com.pimo.Activity

import android.os.Bundle
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

        Button_gps.setOnClickListener {

        }

    }


}