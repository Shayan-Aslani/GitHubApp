package com.shayanaslani.rxsample.adapter;

import android.app.Activity;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shayanaslani.rxsample.R;
import com.shayanaslani.rxsample.databinding.ItemGithubRepoBinding;
import com.shayanaslani.rxsample.model.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GitHubRepoAdapter extends RecyclerView.Adapter<GitHubRepoAdapter.RepoHolder> {

    private List<GitHubRepo> reposList = new ArrayList<>();

    @Inject
    public GitHubRepoAdapter(){
    }
    public void setGitHubRepos(@Nullable List<GitHubRepo> repos) {
        if (repos == null)
            return;
        reposList.clear();
        reposList.addAll(repos);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Activity activity = (Activity) viewGroup.getContext();
        ItemGithubRepoBinding binding = DataBindingUtil.inflate(activity.getLayoutInflater()
                , R.layout.item_github_repo , viewGroup , false);
        return new RepoHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoHolder viewHolder, int i) {
        viewHolder.bind(reposList.get(i));
    }

    @Override
    public int getItemCount() {
        return reposList == null ? 0 : reposList.size();
    }

    public class RepoHolder extends RecyclerView.ViewHolder {

        private ItemGithubRepoBinding mBinding;
        private GitHubRepo mGitHubRepo;

        public RepoHolder(@NonNull ItemGithubRepoBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(GitHubRepo gitHubRepo) {
            mGitHubRepo = gitHubRepo;
            mBinding.textRepoName.setText(gitHubRepo.getName());
            mBinding.textRepoDescription.setText(gitHubRepo.getDescription());
            mBinding.textLanguage.setText("Language: " + gitHubRepo.getLanguage());
            mBinding.textStars.setText("Stars: " + gitHubRepo.getStargazersCount());
        }
    }
}
