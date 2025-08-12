package com.github_repos.config;

import com.github_repos.client.GitHubApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public GitHubApiClient gitHubApiClient() {
        return new GitHubApiClient(restTemplate());
    }
}
