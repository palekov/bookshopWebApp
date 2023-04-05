package com.palekov.bookshop.service.repository;

import com.palekov.bookshop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(Long id);

    List<User> findAll();
}
