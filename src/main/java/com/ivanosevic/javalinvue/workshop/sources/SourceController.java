package com.ivanosevic.javalinvue.workshop.sources;

import com.ivanosevic.javalinvue.workshop.core.Controller;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class SourceController implements Controller {

    private final SourceService sourceService;

    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    public void findAllSources(Context ctx) {
        var sources = sourceService.findAll();
        if (sources.isEmpty()) {
            ctx.status(HttpStatus.NO_CONTENT);
            return;
        }
        ctx.json(sources);
    }

    public void findSourceById(Context ctx) {
        var sourceName = ctx.pathParam("sourceName");
        var sourceOptional = sourceService.findByName(sourceName);
        if (sourceOptional.isEmpty()) {
            ctx.status(HttpStatus.NOT_FOUND);
            return;
        }
        var source = sourceOptional.get();
        ctx.json(source);
    }

    @Override
    public void routes(Javalin javalin) {
        javalin.get("/api/v1/sources", this::findAllSources);
        javalin.get("/api/v1/sources/{sourceName}", this::findSourceById);
    }
}