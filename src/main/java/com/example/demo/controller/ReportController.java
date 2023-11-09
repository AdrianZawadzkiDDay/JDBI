package com.example.demo.controller;

import com.example.demo.repository.mapper.ReportDTO;
import com.example.demo.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService reportService;

    @GetMapping()
    public ResponseEntity<ReportDTO> getResult() {
        log.info("Get report result.");
        return new ResponseEntity<>(reportService.getReport(), HttpStatus.OK);
    }

}
