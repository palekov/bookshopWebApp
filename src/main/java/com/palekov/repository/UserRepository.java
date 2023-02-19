package com.palekov.repository;

import com.palekov.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(Long id);

    List<User> findAll();
}
