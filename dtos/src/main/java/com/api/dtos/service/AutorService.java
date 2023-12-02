package com.api.dtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dtos.model.Autor;
import com.api.dtos.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> findAllAutores() {
        return autorRepository.findAll();
    }

    public Optional<Autor> findAutorById(Long id) {
        return autorRepository.findById(id);
    }

    public Autor updateAutor(Long id, Autor autorDetails) {
        Autor autor = autorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Autor não encontrado com id: " + id));
        
        autor.setNome(autorDetails.getNome());
        return autorRepository.save(autor);
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

}