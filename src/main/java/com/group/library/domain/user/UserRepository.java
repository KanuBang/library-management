package com.group.library.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    List<User> findAllByAgeBetween(int startAge, int endAge);
}
