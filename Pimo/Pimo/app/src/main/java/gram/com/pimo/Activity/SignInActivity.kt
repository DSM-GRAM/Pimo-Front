package gram.com.pimo.Activity

import android.content.Intent
import android.os.Bundle
import com.google.gson.JsonObject
import gram.com.pimo.Connector.Connector
import gram.com.pimo.R
import gram.com.pimo.Util.BaseActivity
import kotlinx.android.synthetic.main.signin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by root1 on 2017. 11. 7..
 */
class SignInActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)

        button_signin.setOnClickListener {
            if (edit_id.text.toString().isEmpty() || edit_password.text.toString().isEmpty()){
                showToast("값을 다 입력하세요")
            }else{
                Connector.api?.signIn(edit_id.text.toString(), edit_password.text.toString())?.enqueue(object : Callback<JsonObject>{
                    override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                        if (response?.code() == 201){
                            val editor = getPref().edit()
                            editor.putString("token", response?.body()?.get("access_code")?.asString!!)
                            editor.commit()
                            val intent = Intent(this@SignInActivity, MemoListActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            showToast("로그인에 실패했습니다.")
                        }
                    }

                    override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                        t?.printStackTrace()
                    }
                })
            }
        }

        text_goto_cerfication.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


    }


}