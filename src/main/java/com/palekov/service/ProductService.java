package com.palekov.service;

import com.palekov.dto.ProductDto;
import com.palekov.mapper.ProductMapper;
import com.palekov.repository.ProductRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    protected final ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    public ProductDto getProductById(Long productId) {
        return mapper.toProductDto(productRepository.findProductById(productId));
    }

    public List<ProductDto> getAllProducts() {
        return mapper.toListOfProductDto(productRepository.findAll());
    }

    public ProductDto createProduct(ProductDto productDto) {
        productRepository.save(mapper.toProductEntity(productDto));
        return productDto;
    }
}
