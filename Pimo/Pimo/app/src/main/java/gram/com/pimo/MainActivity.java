package gram.com.pimo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        // 스플래시 화면 띄우기
        startActivity(new Intent(this, SplashActivity.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        initialize();  // 시간이 걸리는 작업 처리
    }

    /**
     * 스플래시 표시하는 것과 초기화를 동시에 진행시키기 위하여 쓰레드 처리
     *
     */
    private void initialize()
    {
        InitializationRunnable init = new InitializationRunnable();
        new Thread(init).start();
    }

    /**
     * 초기화 작업 처리
     *
     */
    class InitializationRunnable implements Runnable
    {
        public void run()
        {
            // 여기서부터 초기화 작업 처리
            // do_something
        }
    }
}