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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailyReportRequestDto {

    private int userId;
    private LocalDate reportDate;
    private double totalCalories;
    private boolean isWithinLimit;
    private LocalDateTime createdAt = LocalDateTime.now();

}
