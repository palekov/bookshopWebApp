package com.palekov.bookshop.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String author;
    private Float price;
    private String image_path;
}
