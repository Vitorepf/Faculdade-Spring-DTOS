package com.api.dtos.controller;

import com.api.dtos.model.Autor;
import com.api.dtos.dto.AutorDTO;
import com.api.dtos.mapper.AutorMapper;
import com.api.dtos.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorDTO> createAutor(@RequestBody AutorDTO autorDTO) {
        Autor autor = AutorMapper.toEntity(autorDTO);
        Autor novoAutor = autorService.saveAutor(autor);
        AutorDTO novoAutorDTO = AutorMapper.toDTO(novoAutor);
        return ResponseEntity.ok(novoAutorDTO);
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> getAllAutores() {
        List<AutorDTO> autoresDTO = autorService.findAllAutores().stream()
            .map(AutorMapper::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(autoresDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> getAutorById(@PathVariable Long id) {
        return autorService.findAutorById(id)
            .map(AutorMapper::toDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> updateAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        Autor autorAtualizado = autorService.updateAutor(id, AutorMapper.toEntity(autorDTO));
        AutorDTO autorAtualizadoDTO = AutorMapper.toDTO(autorAtualizado);
        return ResponseEntity.ok(autorAtualizadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return ResponseEntity.ok().build();
    }
}
