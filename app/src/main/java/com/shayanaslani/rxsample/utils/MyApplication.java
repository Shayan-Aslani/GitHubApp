package com.shayanaslani.rxsample.utils;

import android.app.Application;

import com.shayanaslani.rxsample.DaggerAppComponent;
import com.shayanaslani.rxsample.component.AppComponent;
import com.shayanaslani.rxsample.modules.AppContextModule;
import com.shayanaslani.rxsample.modules.AppModule;
import com.shayanaslani.rxsample.modules.RepositoryModule;
import com.shayanaslani.rxsample.modules.RetrofitModule;

public class MyApplication extends Application {
    private static AppComponent component ;

    public static AppComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    public AppComponent buildComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .appContextModule(new AppContextModule(this))
                .retrofitModule(new RetrofitModule())
                .repositoryModule(new RepositoryModule())
                .build();
    }
}
