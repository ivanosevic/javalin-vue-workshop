package com.ivanosevic.javalinvue.workshop.quotes;

import com.ivanosevic.javalinvue.workshop.core.Controller;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class QuoteController implements Controller {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    public void findAllQuotes(Context ctx) {
        var quotes = quoteService.findAll();
        if (quotes.isEmpty()) {
            ctx.status(HttpStatus.NO_CONTENT);
            return;
        }
        ctx.json(quotes);
    }

    public void findQuoteById(Context ctx) {
        Integer quoteId = ctx.pathParamAsClass("quoteId", Integer.class).get();
        var quoteOptional = quoteService.findById(quoteId);
        if (quoteOptional.isEmpty()) {
            ctx.status(HttpStatus.NOT_FOUND);
            return;
        }
        var quote = quoteOptional.get();
        ctx.json(quote);
    }

    public void createQuote(Context ctx) {
        String content = ctx.formParam("content");
        String source = ctx.formParam("source");
        QuoteForm quoteForm = new QuoteForm(content, source);
        quoteService.createQuote(quoteForm);
        ctx.redirect("/");
    }

    @Override
    public void routes(Javalin javalin) {
        javalin.get("/api/v1/quotes", this::findAllQuotes);
        javalin.get("/api/v1/quotes/{quoteId}", this::findQuoteById);
        javalin.post("/add-quotes", this::createQuote);
    }
}