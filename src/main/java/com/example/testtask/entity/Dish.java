package com.example.testtask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Dish name cannot be null")
    @Size(min = 1, max = 255, message = "Dish name must be between 1 and 255 characters")
    private String name;

    @NotNull(message = "Calories per serving cannot be null")
    @DecimalMin(value = "0.1", message = "Calories per serving must be greater than 0")
    private double caloriesPerServing;

    @NotNull(message = "Protein cannot be null")
    @DecimalMin(value = "0.1", message = "Protein must be greater than 0")
    private double protein;

    @NotNull(message = "Fat cannot be null")
    @DecimalMin(value = "0.1", message = "Fat must be greater than 0")
    private double fats;

    @NotNull(message = "Carbs cannot be null")
    @DecimalMin(value = "0.1", message = "Carbs must be greater than 0")
    private double carbs;

    @Column(name = "created_at", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdAt;
}
