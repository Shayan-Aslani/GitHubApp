package com.shayanaslani.rxsample.model;

public class GitHubRepo {

    private int id;
    private String name;
    private String htmlUrl;
    private String description;
    private String language;
    private int stargazersCount;

    public GitHubRepo(int id, String name, String htmlUrl, String description, String language, int stargazersCount) {
        this.id = id;
        this.name = name;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.language = language;
        this.stargazersCount = stargazersCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }
}