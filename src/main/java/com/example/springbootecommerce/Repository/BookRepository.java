package com.example.springbootecommerce.Repository;

import com.example.springbootecommerce.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
