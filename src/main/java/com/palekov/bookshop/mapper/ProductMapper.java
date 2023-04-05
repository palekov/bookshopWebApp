package com.palekov.bookshop.mapper;

import com.palekov.bookshop.dto.ProductDto;
import com.palekov.bookshop.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProductEntity(ProductDto source);

    ProductDto toProductDto(Product source);

    List<ProductDto> toListOfProductDto(Iterable<Product> source);
}
