package com.example.testtask.controller;

import com.example.testtask.dto.FoodRequestDto;
import com.example.testtask.dto.FoodResponseDto;
import com.example.testtask.entity.Food;
import com.example.testtask.service.FoodService;
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

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/{id}")
    public ResponseEntity<FoodResponseDto> addFood(@PathVariable int id,
                                                   @RequestBody @Valid FoodRequestDto foodRequestDto) {
        FoodResponseDto foodResponseDto = foodService.addFood(id, foodRequestDto);
        return new ResponseEntity<>(foodResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodResponseDto>> getAllFood() {
        List<FoodResponseDto> allFoods = foodService.getAllFoods();
        return new ResponseEntity<>(allFoods, HttpStatus.OK);
    }

    @PutMapping("/{user_id}/{food_id}")
    public ResponseEntity<FoodResponseDto> updateFood(@PathVariable int user_id, @PathVariable int food_id,
                                                      @RequestBody @Valid FoodRequestDto foodRequestDto) throws AccessDeniedException {
        FoodResponseDto foodResponseDto = foodService.updateFood(user_id, food_id, foodRequestDto);
        return new ResponseEntity<>(foodResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable int id) {
        Food food = foodService.getFoodById(id);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FoodResponseDto> deleteFood(@PathVariable int id) {
        foodService.deleteFoodById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
