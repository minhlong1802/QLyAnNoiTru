package com.example.QLyAnNoiTru.ConsumptionStatistic;

import com.example.QLyAnNoiTru.Account.JdbcTemplateService;
import com.example.QLyAnNoiTru.ConsumptionStatistic.ConsumptionStatistic;
import com.example.QLyAnNoiTru.ConsumptionStatistic.ConsumptionStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consumption-statistic")
public class ConsumptionStatisticController {
    private final ConsumptionStatisticRepository consumptionStatisticRepository;
    private final JdbcTemplateService jdbcTemplateService;

    @Autowired
    public ConsumptionStatisticController(ConsumptionStatisticRepository consumptionStatisticRepository, JdbcTemplateService jdbcTemplateService) {
        this.consumptionStatisticRepository = consumptionStatisticRepository;
        this.jdbcTemplateService = jdbcTemplateService;
    }

    @GetMapping
    public List<ConsumptionStatistic> findAll() {
        return consumptionStatisticRepository.findAll();
    }
}