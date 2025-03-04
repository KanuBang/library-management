package com.group.library.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String bookName);
}
