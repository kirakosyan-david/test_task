package com.example.testtask.repository;

import com.example.testtask.entity.Food;
import com.example.testtask.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {

    List<Food> findByUserAndMealDate(User user, LocalDate date);
}
