package gram.com.pimo.Activity

import android.content.Intent
import android.os.Bundle
import gram.com.pimo.R
import gram.com.pimo.Util.BaseActivity

/**
 * Created by root1 on 2017. 11. 12..
 */

class SplashActivity: BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        if(getPref().getString("token", "").isEmpty()){
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }else{
<<<<<<< HEAD
            val intent = Intent(this, MemoListActivity::class.java)
=======
//            val intent = Intent(this, MemoListActivity::class.java)
            val intent = Intent(this, MemocompleteActivity::class.java)
>>>>>>> df1babcf3346086233a153b086185a3fc0f56f51
            startActivity(intent)
        }

        finish()
    }

}