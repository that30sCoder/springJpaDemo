package com.that30sCoder.springJpaDemo.bootstrap;

import com.that30sCoder.springJpaDemo.model.Book;
import com.that30sCoder.springJpaDemo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {


    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       bookRepository.deleteAll();



        Book bookDDD = new Book("test","123","random");
        System.out.printf(" ID: "+ bookDDD.getId());
        Book saveDDD = bookRepository.save(bookDDD);
        System.out.printf(" ID: "+ saveDDD.getId());
        Book bookSia = new Book("Spring In Action","23456","Oreilly");
        Book saveSia = bookRepository.save(bookSia);
        bookRepository.findAll().forEach(

                book -> {
                    System.out.println("Book Id: " + book.getId());

                    System.out.println("Book Title: " + book.getTitle());
                }
        );
    }
}
