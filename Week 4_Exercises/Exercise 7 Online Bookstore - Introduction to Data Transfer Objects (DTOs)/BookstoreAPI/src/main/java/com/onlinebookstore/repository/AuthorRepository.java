package com.onlinebookstore.repository;

import com.onlinebookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Additional query methods (if needed) can be defined here
}