package com.example.testtask.repository;

import com.example.testtask.entity.FoodDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodDishRepository extends JpaRepository<FoodDish, Integer> {

    Optional<FoodDish> findByFoodId(int id);

}
