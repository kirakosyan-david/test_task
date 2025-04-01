package com.example.testtask.mapper;

import com.example.testtask.dto.FoodDishRequestDto;
import com.example.testtask.dto.FoodDishResponseDto;
import com.example.testtask.entity.FoodDish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodDishMapper {

    FoodDish mapToFoodDish(FoodDishRequestDto dish);

    FoodDishResponseDto mapToFoodDishResponseDto(FoodDish foodDish);

    List<FoodDishResponseDto> mapToListFoodDish(List<FoodDish> foodDishes);
}
