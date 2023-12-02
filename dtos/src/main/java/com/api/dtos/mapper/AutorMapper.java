package com.api.dtos.mapper;

import com.api.dtos.model.Autor;
import com.api.dtos.dto.AutorDTO;

public class AutorMapper {

    public static AutorDTO toDTO(Autor autor) {
        AutorDTO dto = new AutorDTO();
        dto.setId(autor.getId());
        dto.setNome(autor.getNome());
        return dto;
    }

    public static Autor toEntity(AutorDTO dto) {
        Autor autor = new Autor();
        autor.setId(dto.getId());
        autor.setNome(dto.getNome());
        return autor;
    }
}
