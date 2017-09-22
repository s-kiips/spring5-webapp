package com.sudin.spring5webapp.bootstrap;

import com.sudin.spring5webapp.model.Author;
import com.sudin.spring5webapp.model.Book;
import com.sudin.spring5webapp.model.Publisher;
import com.sudin.spring5webapp.repositories.AuthorRepository;
import com.sudin.spring5webapp.repositories.BookRepository;
import com.sudin.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {

        Publisher publisher=new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        //Sudin
        Author sudin = new Author("Sudin", "Ranjitkar");
        Publisher publisherSudin=new Publisher("ranjitBooks","Sitapaila");
        Book ddd = new Book("Domain Driven Design", "1234",publisher);
        sudin.getBooks().add(ddd);
        ddd.getAuthors().add(sudin);
        authorRepository.save(sudin);
        bookRepository.save(ddd);


        //Sudeen
        Author sudeen = new Author("Sudeen", "Ranjitkar");
        Publisher publisherSudeen=new Publisher("ranjitkarSudeen","kathmandu");
        Book javaEE = new Book("J2EE Development", "24356",publisher);
        sudeen.getBooks().add(javaEE);
        javaEE.getAuthors().add(sudeen);
        authorRepository.save(sudeen);
        bookRepository.save(javaEE);
    }

}
