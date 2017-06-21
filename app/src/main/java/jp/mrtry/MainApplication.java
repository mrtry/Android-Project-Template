package jp.mrtry;

import android.app.Application;
import android.util.Log;

import com.tomoima.debot.DebotConfigurator;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DebotConfigurator.configureWithDefault(this);
    }
}
