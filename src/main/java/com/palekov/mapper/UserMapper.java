package com.palekov.mapper;

import com.palekov.dto.UserDto;
import com.palekov.model.User;
import com.palekov.model.enums.Role;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUserEntity(UserDto source);

    UserDto toUserDto(User source);

    List<UserDto> toListOfUserDto(Iterable<User> source);
}
