package com.group.library.controller.book;

import com.group.library.dto.book.BookLoanRequest;
import com.group.library.dto.book.BookCreateRequest;
import com.group.library.dto.book.BookReturnRequest;
import com.group.library.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 책 저장
    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request){

        bookService.saveBook(request);
    }

    // 책 대출
    @PostMapping("/book/loan")
    public void lonaBook(@RequestBody BookLoanRequest request){
        bookService.loanBook(request);
    }

}
