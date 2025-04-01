package com.example.testtask.service.impl;

import com.example.testtask.dto.DishRequestDto;
import com.example.testtask.dto.DishResponseDto;
import com.example.testtask.entity.Dish;
import com.example.testtask.mapper.DishMapper;
import com.example.testtask.repository.DishRepository;
import com.example.testtask.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Override
    @Transactional
    public DishResponseDto createDish(DishRequestDto dish) {
        Dish saveDish = dishMapper.mapToDish(dish);
        return dishMapper.mapToDishResponseDto(dishRepository.save(saveDish));
    }

    @Override
    @Transactional
    public DishResponseDto updateDish(int id, DishRequestDto dish) {
        DishResponseDto responseDto = getDishById(id);
        Dish editDish = dishMapper.dishToMap(responseDto);
        editDish.setName(dish.getName());
        editDish.setCaloriesPerServing(dish.getCaloriesPerServing());
        editDish.setProtein(dish.getProtein());
        editDish.setFats(dish.getFats());
        editDish.setCarbs(dish.getCarbs());
        return dishMapper.mapToDishResponseDto(dishRepository.save(editDish));
    }

    @Override
    public DishResponseDto getDishById(int id) {
        Dish dish = dishRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Dish not found"));
        return dishMapper.mapToDishResponseDto(dish);
    }

    @Override
    public List<DishResponseDto> getAllDishes() {
        return dishMapper.mapToListDish(dishRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteDish(int id) {
        if (!dishRepository.existsById(id)) {
            throw new IllegalArgumentException("Dish not found");
        }
        dishRepository.deleteById(id);
    }
}
