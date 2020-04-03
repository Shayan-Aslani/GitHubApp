package com.shayanaslani.rxsample.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.shayanaslani.rxsample.repository.Repository;
import com.shayanaslani.rxsample.model.GitHubRepo;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class MainFragmentViewModel extends AndroidViewModel {

    private final Repository mRepositry ;
    private final Context mContext ;

    @Inject
    public MainFragmentViewModel(@NonNull Application application , Repository repository) {
        super(application);
        mRepositry = repository;
        mContext = application ;
    }

    public Observable<List<GitHubRepo>> getStarredRepository(String username){
        return mRepositry.loadStarredRepos(username);
    }
}
