package com.example.testtask.service;

import com.example.testtask.dto.UserRequestDto;
import com.example.testtask.dto.UserResponseDto;
import com.example.testtask.entity.User;
import com.example.testtask.entity.enums.GoalEnum;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto user);

    User getUserById(int id);

    List<UserResponseDto> allUsers();

    UserResponseDto updateUser(int id, UserRequestDto user);

    void deleteUser(int id);


    default double calculateDailyCalories(UserRequestDto user) {
        double bmr = 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getAge() + 5;
        double dailyCalories = 0;
        if (user.getGoal() == GoalEnum.WEIGHT_LOSS) {
            dailyCalories = bmr * 1.2 - 500;
        } else if (user.getGoal() == GoalEnum.MAINTENANCE) {
            dailyCalories = bmr * 1.2;
        } else if (user.getGoal() == GoalEnum.MASS_GAIN) {
            dailyCalories = bmr * 1.5;
        } else {
            throw new IllegalArgumentException("Invalid goal.");
        }
        return dailyCalories;
    }
}
