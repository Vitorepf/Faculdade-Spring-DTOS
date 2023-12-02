package com.api.dtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dtos.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}