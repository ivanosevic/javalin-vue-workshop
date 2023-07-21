package com.ivanosevic.javalinvue.workshop.sources;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SourceMapper implements RowMapper<Source> {

    @Override
    public Source map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Source(rs.getInt("SOURCE_ID"), rs.getString("SOURCE_NAME"), rs.getTimestamp("CREATED_AT").toInstant());
    }
}
