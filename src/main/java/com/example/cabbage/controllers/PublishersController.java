package com.example.cabbage.controllers;

import com.example.cabbage.objects.dao.Publishers;
import com.example.cabbage.objects.dto.ResponseDto;
import com.example.cabbage.services.PublishersService;

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
@RequestMapping("/publishers")
public class PublishersController {
    private PublishersService publishersService;

    @Autowired
    public PublishersController(PublishersService publishersService) {
        this.publishersService = publishersService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto> create(@RequestBody Publishers publisher) throws Exception {
        return ResponseEntity.ok(this.publishersService.create(publisher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publishers> getPublisher(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.publishersService.get(id));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody Publishers publisher) throws Exception {
        return ResponseEntity.ok(this.publishersService.update(publisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.publishersService.delete(id));
    }

}
