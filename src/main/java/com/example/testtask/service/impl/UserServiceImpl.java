package com.example.testtask.service.impl;

import com.example.testtask.dto.UserRequestDto;
import com.example.testtask.dto.UserResponseDto;
import com.example.testtask.entity.User;
import com.example.testtask.mapper.UserMapper;
import com.example.testtask.repository.UserRepository;
import com.example.testtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserResponseDto createUser(UserRequestDto user) {
        User userDto = userMapper.mapToUser(user);
        userDto.setDailyCalories(calculateDailyCalories(user));
        return userMapper.mapToUserResponseDto(userRepository.save(userDto));
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User not found"));
    }

    @Override
    public List<UserResponseDto> allUsers() {
        return userMapper.mapToListUser(userRepository.findAll());
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(int id, UserRequestDto user) {
        User editUser = getUserById(id);
        editUser.setName(user.getName());
        editUser.setEmail(user.getEmail());
        editUser.setAge(user.getAge());
        editUser.setWeight(user.getWeight());
        editUser.setHeight(user.getHeight());
        editUser.setGoal(user.getGoal());
        editUser.setDailyCalories(calculateDailyCalories(user));
        return userMapper.mapToUserResponseDto(userRepository.save(editUser));
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }
}
