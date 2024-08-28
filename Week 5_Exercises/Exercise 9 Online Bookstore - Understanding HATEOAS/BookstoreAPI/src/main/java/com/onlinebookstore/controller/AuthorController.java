package com.onlinebookstore.controller;

import com.onlinebookstore.model.Author;
import com.onlinebookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Author>> getAuthorById(@PathVariable Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        EntityModel<Author> resource = EntityModel.of(author);

        // Adding HATEOAS link to this resource
        resource.add(WebMvcLinkBuilder.linkTo(methodOn(AuthorController.class).getAllAuthors()).withRel("all-authors"));
        resource.add(WebMvcLinkBuilder.linkTo(methodOn(AuthorController.class).getAuthorById(id)).withSelfRel());

        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Author>>> getAllAuthors() {
        List<EntityModel<Author>> authors = authorRepository.findAll().stream()
                .map(author -> EntityModel.of(author)
                        .add(WebMvcLinkBuilder.linkTo(methodOn(AuthorController.class).getAuthorById(author.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(authors);
    }

    // Other methods (POST, PUT, DELETE) would also include similar HATEOAS links
}
