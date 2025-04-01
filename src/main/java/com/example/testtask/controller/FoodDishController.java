package com.example.testtask.controller;

import com.example.testtask.dto.FoodDishRequestDto;
import com.example.testtask.dto.FoodDishResponseDto;
import com.example.testtask.entity.FoodDish;
import com.example.testtask.service.FoodDishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/food-dishes")
@RequiredArgsConstructor
public class FoodDishController {

    private final FoodDishService foodDishService;

    @PostMapping
    public ResponseEntity<FoodDishResponseDto> createFoodDish(@RequestBody @Valid FoodDishRequestDto foodDish) {
        FoodDishResponseDto responseDto = foodDishService.createFoodDish(foodDish);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDish> getFoodDish(@PathVariable int id) {
        FoodDish dishById = foodDishService.getFoodDishById(id);
        return new ResponseEntity<>(dishById, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FoodDishResponseDto>> getAllFoodDishes() {
        List<FoodDishResponseDto> foodDishes = foodDishService.getAllFoodDishes();
        return new ResponseEntity<>(foodDishes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodDishResponseDto> updateFooDish(@PathVariable int id,
                                                             @RequestBody @Valid FoodDishRequestDto foodDish) {
        FoodDishResponseDto responseDto = foodDishService.updateFoodDish(id, foodDish);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FoodDishResponseDto> deleteFoodDish(@PathVariable int id) {
        foodDishService.deleteFoodDishById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
