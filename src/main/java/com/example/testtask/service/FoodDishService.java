package com.example.testtask.service;

import com.example.testtask.dto.FoodDishRequestDto;
import com.example.testtask.dto.FoodDishResponseDto;
import com.example.testtask.entity.FoodDish;

import java.util.List;

public interface FoodDishService {
    FoodDishResponseDto createFoodDish(FoodDishRequestDto foodDish);

    FoodDish getFoodDishById(int id);

    List<FoodDishResponseDto> getAllFoodDishes();

    FoodDishResponseDto updateFoodDish(int id, FoodDishRequestDto foodDish);

    void deleteFoodDishById(int id);
}
