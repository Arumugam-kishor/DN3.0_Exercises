package com.onlinebookstore.controller;

import com.onlinebookstore.dto.AuthorDTO;
import com.onlinebookstore.model.Author;
import com.onlinebookstore.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = modelMapper.map(authorDTO, Author.class);
        Author savedAuthor = authorService.saveAuthor(author);
        AuthorDTO savedAuthorDTO = modelMapper.map(savedAuthor, AuthorDTO.class);
        return ResponseEntity.ok(savedAuthorDTO);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        List<AuthorDTO> authorDTOs = authors.stream()
                .map(author -> modelMapper.map(author, AuthorDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(authorDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);
        AuthorDTO authorDTO = modelMapper.map(author, AuthorDTO.class);
        return ResponseEntity.ok(authorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        Author author = modelMapper.map(authorDTO, Author.class);
        Author updatedAuthor = authorService.updateAuthor(id, author);
        AuthorDTO updatedAuthorDTO = modelMapper.map(updatedAuthor, AuthorDTO.class);
        return ResponseEntity.ok(updatedAuthorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
