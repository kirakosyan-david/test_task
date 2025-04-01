package com.example.testtask.mapper;

import com.example.testtask.dto.DishRequestDto;
import com.example.testtask.dto.DishResponseDto;
import com.example.testtask.entity.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {

    Dish mapToDish(DishRequestDto dish);

    Dish dishToMap(DishResponseDto dish);

    DishResponseDto mapToDishResponseDto(Dish dish);

    List<DishResponseDto> mapToListDish(List<Dish> dishes);
}
