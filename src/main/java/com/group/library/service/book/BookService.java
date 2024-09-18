package com.group.library.service.book;

import com.group.library.domain.book.Book;
import com.group.library.domain.book.BookJpaRepository;
import com.group.library.domain.user.UserRepository;
import com.group.library.domain.user.loanHistory.UserLoanHistory;
import com.group.library.domain.user.loanHistory.UserLoanHistoryRepository;
import com.group.library.dto.book.BookLoanRequest;
import com.group.library.dto.book.BookCreateRequest;
import com.group.library.dto.book.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.group.library.domain.user.User;

@Service
public class BookService {

    private final BookJpaRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    public BookService(BookJpaRepository bookRepository,
                       UserLoanHistoryRepository userLoanHistoryRepository,
                       UserRepository userRepository
    ) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    // 첵 저장
    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }


    // 책 대출
    @Transactional
    public void loanBook(BookLoanRequest request){

        // 대출할려는 책 존재 확인
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalAccessError::new);

        // 대출 중인지 확인
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            throw new IllegalArgumentException("대출되어 있는 책입니다");
        }

        // 유저 존재하는 지 확인
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        // 유저가 책을 대출한다는 사실을 DB에 저장
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getName()));
    }

    // 책 반납
    @Transactional
    public void returnBook(BookReturnRequest request) {
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        history.doReturn(); //반납, @Transactional -> 영속성 컨텍스트 -> 변경 감지 -> 쿼리 발생
    }
}
