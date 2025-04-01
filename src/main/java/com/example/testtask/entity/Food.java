package com.example.testtask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Meal date cannot be null")
    private LocalDate mealDate;

    @NotNull(message = "Total calories cannot be null")
    @DecimalMin(value = "0.1", message = "Total calories must be greater than 0")
    private double totalCalories;

    @Column(name = "created_at", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdAt;
}
