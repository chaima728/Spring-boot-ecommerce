package com.example.springbootecommerce;


import com.example.springbootecommerce.Models.Book;
import com.example.springbootecommerce.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "books")
public class BookController {

    private byte[] bytes;

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/allbooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    @PostMapping("/savebook")
    public void addbook(@RequestBody Book book) throws IOException {
        book.setPicByte(this.bytes);
        bookRepository.save(book);
        this.bytes = null;
    }

    @DeleteMapping(path = { "/{id}" })
    public void deletebook(@PathVariable("id") long id) {
        bookRepository.deleteById(id);
    }


    @PutMapping("/update")
    public void updateBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

}
