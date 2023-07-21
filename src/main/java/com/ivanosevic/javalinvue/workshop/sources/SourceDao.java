package com.ivanosevic.javalinvue.workshop.sources;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;
import java.util.Optional;

public interface SourceDao {

    @SqlQuery(" SELECT S.SOURCE_ID, S.SOURCE_NAME, S.CREATED_AT FROM PUBLIC.SOURCE S ")
    @UseRowMapper(SourceMapper.class)
    List<Source> findAll();

    @SqlQuery(" SELECT SOURCE_ID, SOURCE_NAME, CREATED_AT FROM PUBLIC.SOURCE WHERE SOURCE_NAME = :name")
    @UseRowMapper(SourceMapper.class)
    Optional<Source> findByName(@Bind("name") String name);

    @SqlQuery(" SELECT SOURCE_ID FROM PUBLIC.SOURCE WHERE SOURCE_NAME = :sourceName")
    Integer getSourceIdFromName(@Bind("sourceName") String sourceName);

    @SqlUpdate(" INSERT INTO PUBLIC.SOURCE(SOURCE_NAME) VALUES(:source)")
    @GetGeneratedKeys
    Integer create(@Bind("source") String source);
}
