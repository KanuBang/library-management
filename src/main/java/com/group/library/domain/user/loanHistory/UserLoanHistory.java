package com.group.library.domain.user.loanHistory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long userId;
    private String bookName;
    private boolean isReturn;

    public UserLoanHistory() {
    }

    public UserLoanHistory(long userId, String bookName) {
        this.userId = userId;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isReturn() {
        return isReturn;
    }

    //반납, @Transactional -> 영속성 컨텍스트 -> 변경 감지 -> 쿼리 발생
    public void doReturn(){
        this.isReturn = true;
    }
}
