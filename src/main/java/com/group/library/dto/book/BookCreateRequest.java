package com.group.library.dto.book;

public class BookCreateRequest {
    private String name;

    public BookCreateRequest() {
    }

    public BookCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
