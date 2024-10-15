package com.group.library.dto.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookLoanRequest {
    private String userName;
    private String bookName;
}
