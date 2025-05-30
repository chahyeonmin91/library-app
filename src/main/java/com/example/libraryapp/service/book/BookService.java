package com.example.libraryapp.service.book;


import com.example.libraryapp.domain.book.Book;
import com.example.libraryapp.domain.book.BookRepository;
import com.example.libraryapp.dto.book.request.BookCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

}
 