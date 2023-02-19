package com.palekov.service;

import com.palekov.dto.UserDto;
import com.palekov.mapper.UserMapper;
import com.palekov.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    protected final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public UserDto getUserById(Long userId) {
        return mapper.toUserDto(userRepository.findUserById(userId));
    }

    public List<UserDto> getAllUsers() {
        return mapper.toListOfUserDto(userRepository.findAll());
    }

    public UserDto createUser(UserDto userDto) {
        userRepository.save(mapper.toUserEntity(userDto));
        return userDto;
    }
}
