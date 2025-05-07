package com.assignment.college.repository;

import com.assignment.college.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Add any custom query methods here if needed
}
