package com.api.dtos.controller;

import com.api.dtos.dto.LivroDTO;
import com.api.dtos.mapper.LivroMapper;
import com.api.dtos.model.Livro;
import com.api.dtos.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroDTO> createLivro(@RequestBody LivroDTO livroDTO) {
        Livro livro = LivroMapper.toEntity(livroDTO);
        Livro novoLivro = livroService.saveLivro(livro);
        LivroDTO novoLivroDTO = LivroMapper.toDTO(novoLivro);
        return ResponseEntity.ok(novoLivroDTO);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> getAllLivros() {
        List<LivroDTO> livrosDTO = livroService.findAllLivros().stream()
            .map(LivroMapper::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(livrosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> getLivroById(@PathVariable Long id) {
        return livroService.findLivroById(id)
            .map(LivroMapper::toDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> updateLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        Livro livroAtualizado = livroService.updateLivro(id, LivroMapper.toEntity(livroDTO));
        LivroDTO livroAtualizadoDTO = LivroMapper.toDTO(livroAtualizado);
        return ResponseEntity.ok(livroAtualizadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
        return ResponseEntity.ok().build();
    }
}
