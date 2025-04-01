package com.example.testtask.mapper;

import com.example.testtask.dto.DailyReportRequestDto;
import com.example.testtask.dto.DailyReportResponseDto;
import com.example.testtask.dto.FoodDishRequestDto;
import com.example.testtask.dto.FoodDishResponseDto;
import com.example.testtask.entity.DailyReport;
import com.example.testtask.entity.FoodDish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DailyReportMapper {

    DailyReport mapToDailyReport(DailyReportRequestDto dailyReport);

    DailyReportResponseDto mapTodailyReportResponseDto(DailyReport dailyReport);

    List<DailyReportResponseDto> mapToListDailyReport(List<DailyReport> dailyReports);
}
