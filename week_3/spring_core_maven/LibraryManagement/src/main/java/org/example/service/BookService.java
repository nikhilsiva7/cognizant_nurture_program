package org.example.service;
import org.example.repository.BookRepository;
public class BookService {

    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    public void processBookRequest(){
        System.out.println("BookService: Processing a new book request...");
        if (bookRepository!=null){
            bookRepository.saveBook();
        }else{
            System.out.println("Error: BookRepository dependency was not injected.");
        }
    }
}
