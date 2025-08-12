package com.github_repos.controller;

import com.github_repos.model.GitHubRepoDetails;
import com.github_repos.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("/repositories/{username}")
    public List<GitHubRepoDetails> getUserRepositories(@PathVariable String username) {
        return gitHubService.getNonForkRepositories(username);
    }
}
