package com.api.dtos.mapper;

import com.api.dtos.model.Livro;
import com.api.dtos.dto.LivroDTO;

public class LivroMapper {

    public static LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setIsbn(livro.getIsbn());
        dto.setNomeAutor(livro.getAutor().getNome());
        return dto;
    }

    public static Livro toEntity(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setId(dto.getId());
        livro.setTitulo(dto.getTitulo());
        livro.setIsbn(dto.getIsbn());
        return livro;
    }
}