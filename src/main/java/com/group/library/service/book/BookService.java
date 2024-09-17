package com.group.library.service.book;

import com.group.library.domain.book.Book;
import com.group.library.domain.book.BookJpaRepository;
import com.group.library.dto.book.BookCreateRequest;
import com.group.library.repository.book.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookJpaRepository bookRepository;

    public BookService(BookJpaRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }
}
