package com.example.demo.repository.mapper;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRowMapper implements RowMapper<ReportDTO> {
    @Override
    public ReportDTO map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new ReportDTO(
                rs.getInt("amount"),
                rs.getDouble("price_sum"),
                rs.getInt("all_products"));
    }
}
