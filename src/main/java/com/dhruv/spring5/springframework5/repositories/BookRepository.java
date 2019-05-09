package com.dhruv.spring5.springframework5.repositories;

import com.dhruv.spring5.springframework5.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
