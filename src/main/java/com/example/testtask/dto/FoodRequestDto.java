package com.example.testtask.dto;

import com.example.testtask.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodRequestDto {

    private User user;
    private LocalDate mealDate;
    private double totalCalories;
    private LocalDateTime createdAt = LocalDateTime.now();
}
