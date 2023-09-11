package service;

import org.springframework.beans.factory.annotation.Autowired;
import repository.BookRepository;

public class BookService {
    @Autowired
    BookRepository bookRepository;
    public  BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
}
