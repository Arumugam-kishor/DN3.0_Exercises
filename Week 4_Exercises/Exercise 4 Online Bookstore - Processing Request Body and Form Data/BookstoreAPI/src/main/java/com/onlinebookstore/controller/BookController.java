package com.onlinebookstore.controller;

import com.onlinebookstore.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // Get book by ID using PathVariable
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                    .filter(book -> book.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    // Create a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    // Update an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId().equals(id)) {
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        return null;
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return "Book with ID " + id + " deleted.";
    }

    // Filter books by title and author using Query Parameters
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author) {
        return books.stream()
                    .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                                    (author == null || book.getAuthor().equalsIgnoreCase(author)))
                    .collect(Collectors.toList());
    }
}
