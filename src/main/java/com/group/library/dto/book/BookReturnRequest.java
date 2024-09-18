package com.group.library.dto.book;

public class BookReturnRequest {
    private String userName;
    private String bookName;

    public BookReturnRequest() {
    }

    public BookReturnRequest(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return bookName;
    }
}
