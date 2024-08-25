package com.onlinebookstore.controller;

import com.onlinebookstore.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    // GET method to retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookList;
    }

    // GET method to retrieve a book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // POST method to add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        book.setId((long) (bookList.size() + 1)); // Simple ID assignment
        bookList.add(book);
        return book;
    }

    // PUT method to update an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setPrice(bookDetails.getPrice());
            book.setIsbn(bookDetails.getIsbn());
        }
        return book;
    }

    // DELETE method to remove a book by ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookList.removeIf(book -> book.getId().equals(id));
        return "Book with ID " + id + " has been removed.";
    }
}
