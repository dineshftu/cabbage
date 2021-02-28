package com.example.cabbage.repositories;

import java.util.List;

import com.example.cabbage.objects.dao.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

	List<Books> findByAuthorId(Long authorId);

	List<Books> findByPublisherId(Long publisherId);

}
