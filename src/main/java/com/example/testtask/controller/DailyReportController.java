package com.example.testtask.controller;

import com.example.testtask.dto.DailyReportRequestDto;
import com.example.testtask.dto.DailyReportResponseDto;
import com.example.testtask.entity.DailyReport;
import com.example.testtask.service.DailyReportService;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/daily-reports")
@RequiredArgsConstructor
public class DailyReportController {

    private final DailyReportService dailyReportService;

    @PostMapping
    public ResponseEntity<DailyReportResponseDto> createDailyReport(@RequestBody @Valid DailyReportRequestDto dailyReportRequestDto) {
        DailyReportResponseDto dailyReport = dailyReportService.createDailyReport(dailyReportRequestDto);
        return new ResponseEntity<>(dailyReport, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DailyReportResponseDto>> getAllDailyReports() {
        List<DailyReportResponseDto> dailyReports = dailyReportService.getAllDailyReports();
        return new ResponseEntity<>(dailyReports, HttpStatus.OK);
    }

    @GetMapping("/{id}/{date}")
    public ResponseEntity<Optional<DailyReport>> getDailyReport(@PathVariable int id, @PathVariable LocalDate date) {
        Optional<DailyReport> dailyReport = dailyReportService.getDailyReportById(id, date);
        return new ResponseEntity<>(dailyReport, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DailyReportResponseDto> deleteDailyReport(@PathVariable int id) {
        dailyReportService.deleteDailyReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/check/{date}")
    public ResponseEntity<Boolean> checkDailyReport(@PathVariable int id, @PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        boolean caloriesLimit = dailyReportService.isUserWithinCaloriesLimit(id, localDate);
        return new ResponseEntity<>(caloriesLimit, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailyReportResponseDto> updateDailyReport(@PathVariable int id,
                                                                    @RequestBody @Valid DailyReportRequestDto dailyReportRequestDto) {
        DailyReportResponseDto dailyReportResponseDto = dailyReportService.updateDailyReport(id, dailyReportRequestDto);
        return new ResponseEntity<>(dailyReportResponseDto, HttpStatus.OK);
    }

}
