package com.group.library.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookMysqlRepository implements BookRepository{
    @Override
    public void saveBook() {
        System.out.println("mysql repository");
    }
}
