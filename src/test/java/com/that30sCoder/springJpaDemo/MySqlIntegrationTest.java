package com.that30sCoder.springJpaDemo;


import com.that30sCoder.springJpaDemo.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.that30sCoder.springJpaDemo.bootstrap"})
@AutoConfigureTestDatabase(replace =AutoConfigureTestDatabase.Replace.NONE)
public class MySqlIntegrationTest {


    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaDataTransaction(){
        long count = bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
}
