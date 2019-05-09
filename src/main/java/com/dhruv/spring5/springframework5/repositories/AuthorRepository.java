package com.dhruv.spring5.springframework5.repositories;

import com.dhruv.spring5.springframework5.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
