package com.example.libraryapp.domain.user.loanhistory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.scheduling.annotation.EnableAsync;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private long userId;
    private String bookName;
    private boolean isReturn;

    protected UserLoanHistory() {

    }

    public UserLoanHistory(long userId, String bookName) {
        this.bookName = bookName;
        this.isReturn = false;
        this.userId = userId;
    }
}
