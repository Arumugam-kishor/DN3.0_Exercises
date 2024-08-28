package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinebookstore.model.Author;
import com.onlinebookstore.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepository.findById(id)
            .map(author -> {
                author.setName(updatedAuthor.getName());
                author.setBio(updatedAuthor.getBio());
                return authorRepository.save(author);
            })
            .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
