package com.example.testtask.dto;

import com.example.testtask.entity.enums.GoalEnum;
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
public class UserRequestDto {

    private String name;
    private String email;
    private int age;
    private double weight;
    private double height;
    private GoalEnum goal;
    private double dailyCalories;
    private LocalDateTime createdAt = LocalDateTime.now();
}
