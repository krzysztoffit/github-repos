package com.github_repos.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchDetails {

    private String name;
    private String lastCommitSha;
}
