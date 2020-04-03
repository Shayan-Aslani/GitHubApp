package com.shayanaslani.rxsample.component;


import com.shayanaslani.rxsample.modules.AppContextModule;
import com.shayanaslani.rxsample.modules.AppModule;
import com.shayanaslani.rxsample.modules.RepositoryModule;
import com.shayanaslani.rxsample.modules.RetrofitModule;
import com.shayanaslani.rxsample.view.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class , AppContextModule.class , RetrofitModule.class , RepositoryModule.class})
@Singleton
public interface AppComponent {
    void inject(MainFragment mainFragment);
}
