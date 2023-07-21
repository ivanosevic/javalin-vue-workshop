package com.ivanosevic.javalinvue.workshop.quotes;

import com.ivanosevic.javalinvue.workshop.sources.Source;
import com.ivanosevic.javalinvue.workshop.sources.SourceDao;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Optional;

public class QuoteService {

    private final Jdbi jdbi;

    public QuoteService(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Quote> findAll() {
        try (Handle handle = jdbi.open()) {
            QuoteDao quoteDao = handle.attach(QuoteDao.class);
            return quoteDao.findAll();
        }
    }

    public Optional<Quote> findById(Integer quoteId) {
        try (Handle handle = jdbi.open()) {
            QuoteDao quoteDao = handle.attach(QuoteDao.class);
            return quoteDao.findByQuoteId(quoteId);
        }
    }

    public Quote createQuote(QuoteForm quoteForm) {
        return jdbi.inTransaction(handle -> {
            SourceDao sourceDao = handle.attach(SourceDao.class);
            var sourceOptional = sourceDao.findByName(quoteForm.source());
            Integer sourceId = sourceOptional.map(Source::id).orElseGet(() -> sourceDao.create(quoteForm.source()));
            QuoteDao quoteDao = handle.attach(QuoteDao.class);
            handle.commit();
            Integer quoteId = quoteDao.create(quoteForm.content(), sourceId);
            return quoteDao.findByQuoteId(quoteId).get();
        });
    }
}
