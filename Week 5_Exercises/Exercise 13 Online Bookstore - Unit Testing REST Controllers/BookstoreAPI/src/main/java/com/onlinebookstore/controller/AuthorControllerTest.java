package com.onlinebookstore.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinebookstore.dto.AuthorDTO;
import com.onlinebookstore.service.AuthorService;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorService authorService;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreateAuthor() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO("Jane Austen", "An English novelist");

        when(authorService.createAuthor(any(AuthorDTO.class))).thenReturn(authorDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authorDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jane Austen"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bio").value("An English novelist"));
    }

    @Test
    public void testGetAuthorById() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO("Jane Austen", "An English novelist");

        when(authorService.getAuthorById(1L)).thenReturn(authorDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/authors/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Jane Austen"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.bio").value("An English novelist"));
    }
}
