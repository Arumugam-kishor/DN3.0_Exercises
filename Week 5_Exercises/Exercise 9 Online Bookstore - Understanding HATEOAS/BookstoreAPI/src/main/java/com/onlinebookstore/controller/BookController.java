package com.onlinebookstore.controller;

import com.onlinebookstore.model.Book;
import com.onlinebookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Book>> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        EntityModel<Book> resource = EntityModel.of(book);

        // Adding HATEOAS link to this resource
        resource.add(WebMvcLinkBuilder.linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books"));
        resource.add(WebMvcLinkBuilder.linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel());

        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Book>>> getAllBooks() {
        List<EntityModel<Book>> books = bookRepository.findAll().stream()
                .map(book -> EntityModel.of(book)
                        .add(WebMvcLinkBuilder.linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(books);
    }

    // Other methods (POST, PUT, DELETE) would also include similar HATEOAS links
}
