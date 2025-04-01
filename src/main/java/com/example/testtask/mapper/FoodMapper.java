package com.example.testtask.mapper;

import com.example.testtask.dto.FoodRequestDto;
import com.example.testtask.dto.FoodResponseDto;
import com.example.testtask.entity.Food;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    Food mapToFood(FoodRequestDto food);

    FoodResponseDto mapToFoodResponseDto(Food food);

    List<FoodResponseDto> mapToListFood(List<Food> foods);
}
