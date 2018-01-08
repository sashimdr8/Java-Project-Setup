package com.dharmasun;

import android.app.Application;
import android.content.Context;


/**
 * Created by brain on 10/10/17.
 */

public class App extends Application {

    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.applicationComponent = DaggerComponentInitializer.init(this);

    }

    public static AppComponent component(Context context) {
        return ((App) context.getApplicationContext()).applicationComponent;
    }

    private final static class DaggerComponentInitializer {

        static AppComponent init(Context context) {
            return DaggerAppComponent.builder().
                    appModule(new AppModule(context.getApplicationContext()))
                    .build();

        }
    }
}
