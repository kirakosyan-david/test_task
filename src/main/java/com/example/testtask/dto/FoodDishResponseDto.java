package com.example.testtask.dto;

import com.example.testtask.entity.Dish;
import com.example.testtask.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDishResponseDto {

    private Food food;
    private Dish dish;
    private double servingSize;
    private double totalCalories;
}
