package com.example.cabbage.controllers;

import java.util.List;

import com.example.cabbage.objects.dao.Books;
import com.example.cabbage.objects.dto.ResponseDto;
import com.example.cabbage.services.BooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {
    private BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@RequestBody Books publisher) throws Exception {
        return ResponseEntity.ok(this.booksService.create(publisher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBook(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.booksService.get(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody Books publisher) throws Exception {
        return ResponseEntity.ok(this.booksService.update(publisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.booksService.delete(id));
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<List<Books>> getBooksByPublisher(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.booksService.getBooksByPublisher(id));
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<Books>> getBooksByAuthor(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.booksService.getBooksByAuthor(id));
    }

}
