package com.group.library.domain.user.loanHistory;

import com.group.library.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private long userId;
    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;
    private String bookName;
    private boolean isReturn;

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
    }

    public boolean isReturn() {
        return isReturn;
    }

    //반납, @Transactional -> 영속성 컨텍스트 -> 변경 감지 -> 쿼리 발생
    public void doReturn(){
        this.isReturn = true;
    }
}
