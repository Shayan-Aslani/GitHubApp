package com.shayanaslani.rxsample.modules;

import android.content.Context;

import com.shayanaslani.rxsample.network.GitHubService;
import com.shayanaslani.rxsample.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    Repository provideRepository(Context context , GitHubService gitHubService){
        return new Repository(context , gitHubService);
    }
}
