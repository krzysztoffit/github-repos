package com.github_repos.model.api;

import lombok.Data;

@Data
public class Branch {

    private String name;
    private Commit commit;

    @Data
    public static class Commit {
        private String sha;
    }
}
