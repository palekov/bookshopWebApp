package com.palekov.bookshop.mapper;

import com.palekov.bookshop.dto.UserDto;
import com.palekov.bookshop.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUserEntity(UserDto source);

    UserDto toUserDto(User source);

    List<UserDto> toListOfUserDto(Iterable<User> source);
}
