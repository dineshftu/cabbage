package com.example.cabbage.repositories;

import com.example.cabbage.objects.dao.Authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> { 
    
}
