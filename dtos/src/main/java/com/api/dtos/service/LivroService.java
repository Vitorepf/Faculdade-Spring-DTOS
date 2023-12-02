package com.api.dtos.service;

import com.api.dtos.model.Livro;
import com.api.dtos.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAllLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findLivroById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro updateLivro(Long id, Livro livroDetails) {
        Livro livro = livroRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + id));
        
        livro.setTitulo(livroDetails.getTitulo());
        livro.setIsbn(livroDetails.getIsbn());
        livro.setAutor(livroDetails.getAutor());
        return livroRepository.save(livro);
    }
    

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

}