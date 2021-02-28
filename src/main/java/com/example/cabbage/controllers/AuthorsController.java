package com.example.cabbage.controllers;

import com.example.cabbage.objects.dao.Authors;
import com.example.cabbage.objects.dto.ResponseDto;
import com.example.cabbage.services.AuthorsService;

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
@RequestMapping("/author")
public class AuthorsController {
    private AuthorsService authorsService;

    @Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@RequestBody Authors author)
            throws Exception {
        return ResponseEntity.ok(this.authorsService.create(author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Authors> getAuthor(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.authorsService.get(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody Authors author) throws Exception {
        return ResponseEntity.ok(this.authorsService.update(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.authorsService.delete(id));
    }



}
