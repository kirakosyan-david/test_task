package com.example.testtask.entity;

import com.example.testtask.entity.enums.GoalEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email must be valid")
    @Size(max = 255, message = "Email must be less than 255 characters")
    private String email;

    @NotNull(message = "Age cannot be null")
    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    @NotNull(message = "Weight cannot be null")
    @DecimalMin(value = "0.1", message = "Weight must be greater than 0")
    private double weight;

    @NotNull(message = "Height cannot be null")
    @DecimalMin(value = "0.1", message = "Height must be greater than 0")
    private double height;

    @NotNull(message = "Goal cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "goal")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private GoalEnum goal;

    @NotNull(message = "Daily calories cannot be null")
    @DecimalMin(value = "0.1", message = "Daily calories must be greater than 0")
    private double dailyCalories;

    @Column(name = "created_at", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime createdAt;
}
