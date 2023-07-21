package com.ivanosevic.javalinvue.workshop.quotes;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuoteMapper implements RowMapper<Quote> {
    @Override
    public Quote map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Quote(rs.getInt("QUOTE_ID"), rs.getString("QUOTE_CONTENT"), rs.getString("SOURCE_NAME"), rs.getTimestamp("CREATED_AT").toLocalDateTime());
    }
}
