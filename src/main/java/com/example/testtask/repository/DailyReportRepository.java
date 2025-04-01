package com.example.testtask.repository;

import com.example.testtask.entity.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface DailyReportRepository extends JpaRepository<DailyReport, Integer> {

    @Query("SELECT d FROM DailyReport d WHERE d.id = :id AND d.reportDate = :date")
    Optional<DailyReport> findByUserIdAndReportDate(@Param("id") int id, @Param("date") LocalDate date);

}
