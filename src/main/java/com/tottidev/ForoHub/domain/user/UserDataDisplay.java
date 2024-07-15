package com.tottidev.ForoHub.domain.user;

public record UserDataDisplay(
        Long id,
        String username,
        String email
) {
    public UserDataDisplay(User user) {
        this(user.getId(), user.getUsername(), user.getEmail());
    }
}
