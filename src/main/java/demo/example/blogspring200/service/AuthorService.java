package demo.example.blogspring200.service;

import demo.example.blogspring200.model.Author;

import java.util.List;

public interface AuthorService {

    Author create(Author author);

    Author findById(Long id);

    List<Author> findaAll();


}
