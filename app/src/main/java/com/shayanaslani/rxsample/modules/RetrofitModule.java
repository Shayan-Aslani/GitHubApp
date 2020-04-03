package com.shayanaslani.rxsample.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shayanaslani.rxsample.network.GitHubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    private static final String GITHUB_BASE_URL = "https://api.github.com/";

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        return new Retrofit.Builder().baseUrl(GITHUB_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    GitHubService provideGitHubService(Retrofit retrofit){
        return retrofit.create(GitHubService.class);
    }
}
