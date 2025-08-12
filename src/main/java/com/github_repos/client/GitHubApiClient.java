package com.github_repos.client;

import com.github_repos.exception.UserNotFoundException;
import com.github_repos.model.api.Branch;
import com.github_repos.model.api.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GitHubApiClient {

    private final RestTemplate restTemplate;

    public List<Repository> getRepositories(String username) {
        String url = "https://api.github.com/users/{username}/repos";

        try {
            Repository[] response = restTemplate.getForObject(url, Repository[].class, username);
            return Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList());
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new UserNotFoundException(username);
            }
            throw e;
        }
    }

    public List<Branch> getBranches(String username, String repoName) {
        String url = "https://api.github.com/repos/{username}/{repoName}/branches";

        Branch[] response = restTemplate.getForObject(url, Branch[].class, username, repoName);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
}
