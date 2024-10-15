package com.group.library.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
public class BookMemoryRepository implements BookRepository{
    @Override
    public void saveBook() {
        System.out.println("memory repository");
    }
}
