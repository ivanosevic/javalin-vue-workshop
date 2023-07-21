package com.ivanosevic.javalinvue.workshop.quotes;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;
import java.util.Optional;

public interface QuoteDao {

    @SqlQuery("SELECT Q.QUOTE_ID, Q.QUOTE_CONTENT, S.SOURCE_NAME, Q.CREATED_AT FROM PUBLIC.QUOTE Q JOIN PUBLIC.SOURCE S ON Q.SOURCE_ID = S.SOURCE_ID ORDER BY Q.CREATED_AT DESC")
    @UseRowMapper(QuoteMapper.class)
    List<Quote> findAll();

    @SqlQuery("SELECT Q.QUOTE_ID, Q.QUOTE_CONTENT, S.SOURCE_NAME, Q.CREATED_AT FROM PUBLIC.QUOTE Q JOIN PUBLIC.SOURCE S ON Q.SOURCE_ID = S.SOURCE_ID WHERE QUOTE_ID = :quoteId")
    @UseRowMapper(QuoteMapper.class)
    Optional<Quote> findByQuoteId(@Bind("quoteId") Integer quoteId);


    @SqlUpdate("INSERT INTO PUBLIC.QUOTE(QUOTE_CONTENT, SOURCE_ID) VALUES ( :quoteContent, :sourceId )")
    Integer create(@Bind("quoteContent") String quoteContent, @Bind("sourceId") Integer sourceId);
}
