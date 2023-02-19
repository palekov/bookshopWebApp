package com.palekov.repository;

import com.palekov.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findProductById(Long id);

    List<Product> findAll();
}
