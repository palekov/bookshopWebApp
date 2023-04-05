package com.palekov.bookshop.service.repository;

import com.palekov.bookshop.model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

    Store findStoreById(Long id);

    List<Store> findAll();
}
