package com.that30sCoder.springJpaDemo;


import com.that30sCoder.springJpaDemo.model.Book;
import com.that30sCoder.springJpaDemo.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@Commit
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.that30sCoder.springJpaDemo.bootstrap"})
public class SpringBootJpaTest {

    @Autowired
    BookRepository bookRepository;


    @Commit
    @Order(1)
    @Test
    void testJpaData(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
        Book testBook = new Book("Spring by me","12356","S CHAND");
        bookRepository.save(testBook);
        long afterCount = bookRepository.count();
        assertThat(afterCount).isGreaterThan(countBefore);
    }

    @Order(2)
    @Test
    void testJpaDataTransaction(){
        long count = bookRepository.count();
        assertThat(count).isEqualTo(3);
    }



}
