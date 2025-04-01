package com.example.testtask.service;

import com.example.testtask.dto.FoodRequestDto;
import com.example.testtask.dto.FoodResponseDto;
import com.example.testtask.entity.Food;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface FoodService {
    FoodResponseDto addFood(int id, FoodRequestDto foodRequestDto);

    List<FoodResponseDto> getAllFoods();

    Food getFoodById(int id);

    FoodResponseDto updateFood(int userId,int foodId, FoodRequestDto foodRequestDto) throws AccessDeniedException;

    void deleteFoodById(int id);
}
