package com.example.testtask.service;

import com.example.testtask.dto.DishRequestDto;
import com.example.testtask.dto.DishResponseDto;
import com.example.testtask.entity.Dish;

import java.util.List;

public interface DishService {

    DishResponseDto createDish(DishRequestDto dish);

    DishResponseDto updateDish(int id, DishRequestDto dish);

    DishResponseDto getDishById(int id);

    List<DishResponseDto> getAllDishes();

    void deleteDish(int id);
}
