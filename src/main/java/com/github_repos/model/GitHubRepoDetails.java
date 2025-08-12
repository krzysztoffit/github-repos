package com.github_repos.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GitHubRepoDetails {

    private String repositoryName;
    private String ownerLogin;
    private List<BranchDetails> branches;
}
