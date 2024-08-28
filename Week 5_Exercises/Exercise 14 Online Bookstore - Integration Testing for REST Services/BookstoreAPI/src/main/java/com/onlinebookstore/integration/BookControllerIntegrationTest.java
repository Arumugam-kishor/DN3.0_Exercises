package com.onlinebookstore.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinebookstore.model.Book;
import com.onlinebookstore.repository.BookRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        bookRepository.deleteAll();
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book("Java Programming", "James Gosling", "1234567890", 129.59);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Java Programming"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("James Gosling"));
    }

    @Test
    public void testGetBookById() throws Exception {
        Book savedBook = bookRepository.save(new Book("Java Programming", "James Gosling", "1234567890", 129.59));

        mockMvc.perform(MockMvcRequestBuilders.get("/books/" + savedBook.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Java Programming"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("James Gosling"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book savedBook = bookRepository.save(new Book("Java Programming", "James Gosling", "1234567890", 129.59));
        savedBook.setPrice(139.99);

        mockMvc.perform(MockMvcRequestBuilders.put("/books/" + savedBook.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(savedBook)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(139.99));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book savedBook = bookRepository.save(new Book("Java Programming", "James Gosling", "1234567890", 129.59));

        mockMvc.perform(MockMvcRequestBuilders.delete("/books/" + savedBook.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
