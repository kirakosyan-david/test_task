package com.example.testtask.service;

import com.example.testtask.dto.DailyReportRequestDto;
import com.example.testtask.dto.DailyReportResponseDto;
import com.example.testtask.entity.DailyReport;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DailyReportService {
    DailyReportResponseDto createDailyReport(DailyReportRequestDto requestDto);

    Optional<DailyReport> getDailyReportById(int userId, LocalDate date);

    List<DailyReportResponseDto> getAllDailyReports();

    void deleteDailyReport(int id);

    boolean isUserWithinCaloriesLimit(int userId, LocalDate date);

    DailyReportResponseDto updateDailyReport(int id, DailyReportRequestDto requestDto);
}
