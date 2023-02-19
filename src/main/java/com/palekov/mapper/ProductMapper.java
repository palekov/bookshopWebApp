package com.palekov.mapper;

import com.palekov.dto.ProductDto;
import com.palekov.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProductEntity(ProductDto source);

    ProductDto toProductDto(Product source);

    List<ProductDto> toListOfProductDto(Iterable<Product> source);
}
