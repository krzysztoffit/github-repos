package com.github_repos.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("GitHub user '" + username + "' not found.");
    }
}
