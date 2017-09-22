package com.sudin.spring5webapp.bootstrap;

import com.sudin.spring5webapp.model.Author;
import com.sudin.spring5webapp.model.Book;
import com.sudin.spring5webapp.repositories.AuthorRepository;
import com.sudin.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {
        //Sudin
        Author sudin = new Author("Sudin", "Ranjitkar");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        sudin.getBooks().add(ddd);
        ddd.getAuthors().add(sudin);
        authorRepository.save(sudin);
        bookRepository.save(ddd);


        //Sudeen
        Author sudeen = new Author("Sudeen", "Ranjitkar");
        Book javaEE = new Book("J2EE Development", "24356", "sam");
        sudeen.getBooks().add(javaEE);
        javaEE.getAuthors().add(sudeen);
        authorRepository.save(sudeen);
        bookRepository.save(javaEE);
    }

}
