package com.dhruv.spring5.springframework5.bootstrap;

import com.dhruv.spring5.springframework5.model.Author;
import com.dhruv.spring5.springframework5.model.Book;
import com.dhruv.spring5.springframework5.model.Publisher;
import com.dhruv.spring5.springframework5.repositories.AuthorRepository;
import com.dhruv.spring5.springframework5.repositories.BookRepository;
import com.dhruv.spring5.springframework5.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository , PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextrefreshedevent) {
        initData();
    }

    public void initData () {

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddressline1("Swaparnika sanvi Phase 1");
        publisher.setCity("Bangalore");
        publisher.setState("Karnataka");
        publisherRepository.save(publisher);

        Publisher publisher1  = new Publisher();
        publisher1.setName("soo");
        publisher1.setAddressline1("SS Enclave");
        publisher1.setCity("Munnekolala");
        publisher1.setState("Karnataka");
        publisherRepository.save(publisher1);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","1234", publisher );
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","23444", publisher1 );
        eric.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
