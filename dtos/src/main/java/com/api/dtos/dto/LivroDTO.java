package com.api.dtos.dto;

import lombok.Data;

@Data
public class LivroDTO {
    private Long id;
    private String titulo;
    private String isbn;
    private String nomeAutor;

    
}