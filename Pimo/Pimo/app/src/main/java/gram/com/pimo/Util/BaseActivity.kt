package gram.com.pimo.Util

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmObject

/**
 * Created by root1 on 2017. 11. 7..
 */
open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Realm.init(this)
    }

    fun <T: RealmObject> saveData(t: T){
        val realm = getRealm()
        realm.beginTransaction()
        realm.copyFromRealm(t)
        realm.commitTransaction()
    }

    fun getRealm(): Realm{
        return Realm.getDefaultInstance()
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun getPref(): SharedPreferences{
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        return pref
    }

    fun getToken(): String{
        return "JWT " + getPref().getString("token", "")
    }

    fun getStrToEdit(edit: EditText): String{
        return edit.text.toString()
    }

}