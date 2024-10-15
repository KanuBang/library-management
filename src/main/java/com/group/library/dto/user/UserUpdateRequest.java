package com.group.library.dto.user;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserUpdateRequest {
    private long id;
    private String name;

    public UserUpdateRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
