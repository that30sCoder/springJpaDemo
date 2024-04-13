package com.that30sCoder.springJpaDemo.repositories;

import com.that30sCoder.springJpaDemo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 6/12/21.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
