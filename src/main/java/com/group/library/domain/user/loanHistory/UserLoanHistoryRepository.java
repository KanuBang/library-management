package com.group.library.domain.user.loanHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory,Long>{
    // SELECT EXISTS(SELECT 1 FROM book WHERE book_name = ? AND is_return = ?);
    boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);
}
