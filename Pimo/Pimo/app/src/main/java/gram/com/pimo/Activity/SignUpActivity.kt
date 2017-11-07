package gram.com.pimo.Activity

import android.os.Bundle
import gram.com.pimo.Connector.Connector
import gram.com.pimo.R
import gram.com.pimo.Util.BaseActivity
import kotlinx.android.synthetic.main.signup.*

/**
 * Created by root1 on 2017. 11. 7..
 */
class SignUpActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        button_signup.setOnClickListener {
            if(getStrToEdit(edit_cerfiation_id).isEmpty() || getStrToEdit(edit_cerfiation_password).isEmpty() || getStrToEdit(edit_cerfiation_checkpassword).isEmpty()){
                showToast("값을 다 입력하세요.")
            }else{
                if (getStrToEdit(edit_cerfiation_password) == getStrToEdit(edit_cerfiation_checkpassword)){
                    showToast("비밀번호를 다시 확인하세요.")
                }else{
                    Connector.api
                }
            }
        }
    }


}