package gram.com.pimo.Util

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

/**
 * Created by root1 on 2017. 11. 7..
 */
open class BaseActivity: AppCompatActivity() {

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun getPref(): SharedPreferences{
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref
    }

    fun getStrToEdit(edit: EditText): String{
        return edit.text.toString()
    }

}