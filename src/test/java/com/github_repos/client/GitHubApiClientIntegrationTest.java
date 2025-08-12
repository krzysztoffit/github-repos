package com.github_repos.client;

import com.github_repos.config.AppConfig;
import com.github_repos.model.api.Branch;
import com.github_repos.model.api.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AppConfig.class)
public class GitHubApiClientIntegrationTest {

    @Autowired
    private GitHubApiClient gitHubApiClient;

    @Test
    void shouldSuccessfullyRetrieveAllDataForExistingUser() {
        // GIVEN
        String username = "krzysztoffit";

        // WHEN
        List<Repository> repositories = gitHubApiClient.getRepositories(username);

        // THEN
        assertThat(repositories).isNotEmpty();

        String repoName = repositories.get(0).getName();
        List<Branch> branches = gitHubApiClient.getBranches(username, repoName);

        assertThat(branches).isNotEmpty();
        assertThat(branches.get(0).getName()).isNotBlank();
        assertThat(branches.get(0).getCommit().getSha()).isNotBlank();
    }
}
