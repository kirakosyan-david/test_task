package com.example.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishResponseDto {


    private String name;
    private double caloriesPerServing;
    private double protein;
    private double fats;
    private double carbs;
    private LocalDateTime createdAt = LocalDateTime.now();
}
