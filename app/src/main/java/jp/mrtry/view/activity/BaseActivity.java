package jp.mrtry.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.tomoima.debot.Debot;

public abstract class BaseActivity extends AppCompatActivity {

    Debot debot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        debot = Debot.getInstance();
        debot.allowShake(getApplicationContext()); //Make sure to use Application context, or it will leak memory
    }

    @Override
    protected void onResume() {
        super.onResume();
        debot.startSensor(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        debot.stopSensor();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            debot.showDebugMenu(this);
        }
        return super.onKeyUp(keyCode, event);
    }
}
