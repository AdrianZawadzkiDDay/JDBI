package com.example.demo.service.impl;

import com.example.demo.repository.ReportRepository;
import com.example.demo.repository.mapper.ReportDTO;
import com.example.demo.service.ReportService;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    public ReportServiceImpl(Jdbi jdbi) {
        this.reportRepository = jdbi.onDemand(ReportRepository.class);
    }

    @Override
    public ReportDTO getReport() {
        return reportRepository.getResult();
    }
}
