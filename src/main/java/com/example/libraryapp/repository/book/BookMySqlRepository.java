package com.example.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookMySqlRepository implements BookRepository {
    @Override
    public void saveBook() {

    }
}

