package com.group.library.domain.user;

import com.group.library.domain.user.loanHistory.UserLoanHistory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20, name = "name")
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userHistories = new ArrayList<>();

    public User(String name, Integer age) {

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 이름이 들어왔습니다."));
        }

        this.name = name;
        this.age = age;
    }

    // 사용자 이름 수정 로직
    public void updateName(String name) {
        this.name = name;
    }

    // 책 대출 로직
    public void loanBook(String bookName) {
        this.userHistories.add(new UserLoanHistory(this, bookName));
    }
    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userHistories.stream()
                .filter(history -> history.getBookName().equals(bookName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        targetHistory.doReturn();
    }
}
