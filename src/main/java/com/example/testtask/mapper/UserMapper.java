package com.example.testtask.mapper;

import com.example.testtask.dto.UserRequestDto;
import com.example.testtask.dto.UserResponseDto;
import com.example.testtask.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToUser(UserRequestDto user);

    UserResponseDto mapToUserResponseDto(User user);

    List<UserResponseDto> mapToListUser(List<User> users);
}
