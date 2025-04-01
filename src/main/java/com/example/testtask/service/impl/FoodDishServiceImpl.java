package com.example.testtask.service.impl;

import com.example.testtask.dto.FoodDishRequestDto;
import com.example.testtask.dto.FoodDishResponseDto;
import com.example.testtask.entity.Dish;
import com.example.testtask.entity.Food;
import com.example.testtask.entity.FoodDish;
import com.example.testtask.mapper.FoodDishMapper;
import com.example.testtask.repository.DishRepository;
import com.example.testtask.repository.FoodDishRepository;
import com.example.testtask.repository.FoodRepository;
import com.example.testtask.service.FoodDishService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodDishServiceImpl implements FoodDishService {

    private final FoodDishRepository foodDishRepository;
    private final DishRepository dishRepository;
    private final FoodRepository foodRepository;
    private final FoodDishMapper foodDishMapper;


    @Override
    @Transactional
    public FoodDishResponseDto createFoodDish(FoodDishRequestDto requestDto) {
        Food food = foodRepository.findById(requestDto.getFoodId())
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));
        Dish dish = dishRepository.findById(requestDto.getDishId())
                .orElseThrow(() -> new EntityNotFoundException("Dish not found"));

        FoodDish foodDish = FoodDish.builder()
                .food(food)
                .dish(dish)
                .servingSize(requestDto.getServingSize())
                .totalCalories(requestDto.getTotalCalories())
                .build();

        FoodDish save = foodDishRepository.save(foodDish);
        return foodDishMapper.mapToFoodDishResponseDto(save);
    }

    @Override
    public FoodDish getFoodDishById(int id) {
        return foodDishRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Food Dish not found"));
    }

    @Override
    public List<FoodDishResponseDto> getAllFoodDishes() {
        List<FoodDish> foodDishes = foodDishRepository.findAll();
        return foodDishMapper.mapToListFoodDish(foodDishes);
    }

    @Override
    @Transactional
    public FoodDishResponseDto updateFoodDish(int id, FoodDishRequestDto foodDish) {
        Food food = foodRepository.findById(foodDish.getFoodId())
                .orElseThrow(() -> new EntityNotFoundException("Food not found"));
        Dish dish = dishRepository.findById(foodDish.getDishId())
                .orElseThrow(() -> new EntityNotFoundException("Dish not found"));
        FoodDish foodDishById = getFoodDishById(id);
            foodDishById.setDish(dish);
            foodDishById.setFood(food);
            foodDishById.setTotalCalories(foodDish.getTotalCalories());
            foodDishById.setServingSize(foodDish.getServingSize());
            return foodDishMapper.mapToFoodDishResponseDto(getFoodDishById(id));
    }

    @Override
    @Transactional
    public void deleteFoodDishById(int id) {
        if (!foodDishRepository.existsById(id)) {
            throw new IllegalArgumentException("Food Dish not found");
        }
        foodDishRepository.deleteById(id);
    }
}
