package com.github_repos.service;

import com.github_repos.client.GitHubApiClient;
import com.github_repos.model.BranchDetails;
import com.github_repos.model.GitHubRepoDetails;
import com.github_repos.model.api.Branch;
import com.github_repos.model.api.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GitHubService {

    private final GitHubApiClient gitHubApiClient;

    public List<GitHubRepoDetails> getNonForkRepositories(String username) {
        List<Repository> repos = gitHubApiClient.getRepositories(username);

        return repos.stream()
                .filter(repository -> !repository.isFork())
                .map(repository -> {
                    List<Branch> branches = gitHubApiClient.getBranches(username, repository.getName());
                    List<BranchDetails> branchDetailsList = branches.stream()
                            .map(branch -> BranchDetails.builder()
                                    .name(branch.getName())
                                    .lastCommitSha(
                                    branch.getCommit() != null ? branch.getCommit().getSha() : null
                                    )
                                    .build())
                            .collect(Collectors.toList());

                    return GitHubRepoDetails.builder()
                            .repositoryName(repository.getName())
                            .ownerLogin(username)
                            .branches(branchDetailsList)
                            .build();
                })
                .collect(Collectors.toList());
    }
}
