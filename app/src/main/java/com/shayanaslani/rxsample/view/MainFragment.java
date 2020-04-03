package com.shayanaslani.rxsample.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shayanaslani.rxsample.utils.MyApplication;
import com.shayanaslani.rxsample.R;
import com.shayanaslani.rxsample.adapter.GitHubRepoAdapter;
import com.shayanaslani.rxsample.databinding.FragmentMainBinding;
import com.shayanaslani.rxsample.model.GitHubRepo;
import com.shayanaslani.rxsample.viewmodel.MainFragmentViewModel;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @Inject
    GitHubRepoAdapter gitHubRepoAdapter;
    private Subscription subscription;
    private FragmentMainBinding mBinding;

    @Inject
    MainFragmentViewModel mViewModel;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MyApplication.getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        initRecyclerView();
        setListeners();
        return mBinding.getRoot();
    }

    private void setListeners() {
        mBinding.buttonSearch.setOnClickListener(v -> {
            subscription = mViewModel.getStarredRepository(mBinding.editTextUsername.getText().toString())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<List<GitHubRepo>>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onNext(List<GitHubRepo> gitHubRepos) {
                            gitHubRepoAdapter.setGitHubRepos(gitHubRepos);
                        }
                    });
        });

    }

    private void initRecyclerView() {
        mBinding.recyclerViewRepos.setAdapter(gitHubRepoAdapter);
    }

    @Override
    public void onDestroy() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        super.onDestroy();
    }
}
