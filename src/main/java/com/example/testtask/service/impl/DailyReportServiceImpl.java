package com.example.testtask.service.impl;

import com.example.testtask.dto.DailyReportRequestDto;
import com.example.testtask.dto.DailyReportResponseDto;
import com.example.testtask.entity.DailyReport;
import com.example.testtask.entity.User;
import com.example.testtask.mapper.DailyReportMapper;
import com.example.testtask.repository.DailyReportRepository;
import com.example.testtask.repository.UserRepository;
import com.example.testtask.service.DailyReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyReportServiceImpl implements DailyReportService {

    private final DailyReportRepository dailyReportRepository;
    private final UserRepository userRepository;
    private final DailyReportMapper dailyReportMapper;


    @Override
    @Transactional
    public DailyReportResponseDto createDailyReport(DailyReportRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(()
                -> new RuntimeException("User Not Found"));
        DailyReport dailyReport = DailyReport.builder()
                .user(user)
                .reportDate(requestDto.getReportDate())
                .totalCalories(requestDto.getTotalCalories())
                .isWithinLimit(requestDto.isWithinLimit())
                .build();
        return dailyReportMapper.mapTodailyReportResponseDto(dailyReportRepository.save(dailyReport));
    }

    @Override
    public Optional<DailyReport> getDailyReportById(int userId, LocalDate date) {
        return dailyReportRepository.findByUserIdAndReportDate(userId, date);
    }

    @Override
    public List<DailyReportResponseDto> getAllDailyReports() {
        return dailyReportMapper.mapToListDailyReport(dailyReportRepository.findAll());
    }

    @Override
    @Transactional
    public void deleteDailyReport(int id) {
        if (!dailyReportRepository.existsById(id)) {
            throw new IllegalArgumentException("Daily Dish not found");
        }
        dailyReportRepository.deleteById(id);
    }

    @Override
    @Transactional
    public boolean isUserWithinCaloriesLimit(int userId, LocalDate date) {
        Optional<DailyReport> report = getDailyReportById(userId, date);
        return report.map(DailyReport::isWithinLimit).orElse(false);
    }

    @Override
    @Transactional
    public DailyReportResponseDto updateDailyReport(int id, DailyReportRequestDto requestDto) {
        DailyReport editDailyReport = dailyReportRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Food Dish not found"));
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(()
                -> new RuntimeException("User Not Found"));
        editDailyReport.setUser(user);
        editDailyReport.setReportDate(requestDto.getReportDate());
        editDailyReport.setTotalCalories(requestDto.getTotalCalories());
        editDailyReport.setWithinLimit(requestDto.isWithinLimit());
        return dailyReportMapper.mapTodailyReportResponseDto(dailyReportRepository.save(editDailyReport));
    }

}
