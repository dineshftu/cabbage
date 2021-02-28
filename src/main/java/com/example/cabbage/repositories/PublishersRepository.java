package com.example.cabbage.repositories;

import com.example.cabbage.objects.dao.Publishers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishersRepository extends JpaRepository<Publishers, Long> {

}
