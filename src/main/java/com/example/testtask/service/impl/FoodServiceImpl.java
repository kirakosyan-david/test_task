package com.example.testtask.service.impl;

import com.example.testtask.dto.FoodRequestDto;
import com.example.testtask.dto.FoodResponseDto;
import com.example.testtask.entity.Food;
import com.example.testtask.entity.User;
import com.example.testtask.mapper.FoodMapper;
import com.example.testtask.repository.FoodRepository;
import com.example.testtask.repository.UserRepository;
import com.example.testtask.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final UserRepository userRepository;
    private final FoodMapper foodMapper;

    @Override
    @Transactional
    public FoodResponseDto addFood(int id, FoodRequestDto foodRequestDto) {
        Food food = foodMapper.mapToFood(foodRequestDto);
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User not found"));
        food.setUser(user);
        food.setMealDate(LocalDate.now());
        return foodMapper.mapToFoodResponseDto(foodRepository.save(food));
    }

    @Override
    public List<FoodResponseDto> getAllFoods() {
        List<Food> foods = foodRepository.findAll();
        return foodMapper.mapToListFood(foods);
    }

    @Override
    public Food getFoodById(int id) {
        return foodRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Food not found"));
    }

    @Override
    @Transactional
    public FoodResponseDto updateFood(int userId, int foodId, FoodRequestDto foodRequestDto){
        Food food = getFoodById(foodId);

        if (food.getUser().getId() != userId) {
            throw new IllegalArgumentException("User does not have permission to update this food entry");
        }

        food.setMealDate(LocalDate.now());
        food.setTotalCalories(foodRequestDto.getTotalCalories());

        return foodMapper.mapToFoodResponseDto(foodRepository.save(food));
    }

    @Override
    @Transactional
    public void deleteFoodById(int id) {
        if (!foodRepository.existsById(id)) {
            throw new IllegalArgumentException("Food not found");
        }
        foodRepository.deleteById(id);
    }
}
