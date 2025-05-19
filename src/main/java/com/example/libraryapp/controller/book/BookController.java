package com.example.libraryapp.controller.book;


import com.example.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService = new BookService();

    @PostMapping("/book")
    public void saveBook() {
        bookService.saveBook();
    }
}
