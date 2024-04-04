package com.that30sCoder.springJpaDemo.repositories;

import com.that30sCoder.springJpaDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
