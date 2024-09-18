package com.group.library.domain.user;

import com.group.library.domain.user.loanHistory.UserLoanHistory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20, name = "name")
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "user")
    private List<UserLoanHistory> userHistories = new ArrayList<>();
    protected User() {

    }

    public User(String name, Integer age) {

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 이름이 들어왔습니다."));
        }

        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
