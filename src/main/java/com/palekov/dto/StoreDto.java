package com.palekov.dto;

import lombok.Data;

@Data
public class StoreDto {
    private Long id;
    private ProductDto product;
    private Integer available_qty;
    private Integer sold_qty;
}
