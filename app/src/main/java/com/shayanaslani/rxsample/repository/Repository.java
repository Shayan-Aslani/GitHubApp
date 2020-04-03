package com.shayanaslani.rxsample.repository;

import android.content.Context;

import com.shayanaslani.rxsample.model.GitHubRepo;
import com.shayanaslani.rxsample.network.GitHubService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class Repository {

    private GitHubService mService ;
    private Context mContext ;

    @Inject
    public Repository(Context context , GitHubService gitHubService){
        mContext = context ;
        mService = gitHubService;
    }

    public Observable<List<GitHubRepo>> loadStarredRepos(String userName) {
        return mService.getStarredRepositories(userName);
    }
}
