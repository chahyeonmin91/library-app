package com.example.libraryapp.service.book;


import com.example.libraryapp.repository.book.BookMemoryRepository;
import com.example.libraryapp.repository.book.BookRepository;

public class BookService {
    private final BookRepository bookRepository = new BookMemoryRepository();
    public void saveBook() {
        bookRepository.saveBook();
    }

}
