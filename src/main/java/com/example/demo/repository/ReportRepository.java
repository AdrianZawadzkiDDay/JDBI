package com.example.demo.repository;

import com.example.demo.repository.mapper.ReportDTO;
import com.example.demo.repository.mapper.ReportRowMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository {
    @SqlQuery("SELECT count(*) 'amount', sum(price) 'price_sum', sum(qty) 'all_products' FROM PRODUCT;")
    @RegisterRowMapper(ReportRowMapper.class)
    ReportDTO getResult();
}
