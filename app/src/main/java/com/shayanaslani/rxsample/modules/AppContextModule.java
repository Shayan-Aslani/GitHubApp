package com.shayanaslani.rxsample.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppContextModule {
    private final Context context;

    public AppContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    Context getContext() {
        return context;
    }
}
