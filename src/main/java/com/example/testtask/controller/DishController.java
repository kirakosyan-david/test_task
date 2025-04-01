package com.example.testtask.controller;

import com.example.testtask.dto.DishRequestDto;
import com.example.testtask.dto.DishResponseDto;
import com.example.testtask.service.DishService;
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
@RequestMapping("/api/dishes")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;

    @PostMapping
    public ResponseEntity<DishResponseDto> createDish(@RequestBody @Valid DishRequestDto dishRequestDto) {
        DishResponseDto responseDto = dishService.createDish(dishRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DishResponseDto>> getDishes() {
        List<DishResponseDto> allDishes = dishService.getAllDishes();
        return new ResponseEntity<>(allDishes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DishResponseDto> updateDish(@PathVariable int id,
                                                      @RequestBody @Valid DishRequestDto dishRequestDto) {
        DishResponseDto responseDto = dishService.updateDish(id, dishRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishResponseDto> getDishById(@PathVariable int id) {
        DishResponseDto responseDto = dishService.getDishById(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DishResponseDto> deleteDish(@PathVariable int id) {
        dishService.deleteDish(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
