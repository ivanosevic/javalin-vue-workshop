package com.ivanosevic.javalinvue.workshop;

import com.ivanosevic.javalinvue.workshop.quotes.QuoteController;
import com.ivanosevic.javalinvue.workshop.quotes.QuoteService;
import com.ivanosevic.javalinvue.workshop.sources.SourceController;
import com.ivanosevic.javalinvue.workshop.sources.SourceService;
import io.javalin.Javalin;
import io.javalin.vue.VueComponent;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class JavalinVueWorkshopApp {
    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:h2:tcp://localhost/~/Desktop/JCONF/2023/javalin-vue-workshop/database/quotesDatabase", "sa", "sa");
        jdbi.installPlugin(new SqlObjectPlugin());
        var sourceService = new SourceService(jdbi);
        var sourceController = new SourceController(sourceService);

        var quoteService = new QuoteService(jdbi);
        var quoteController = new QuoteController(quoteService);

        Javalin javalin = Javalin.create(config -> {
            config.showJavalinBanner = true;
            config.staticFiles.enableWebjars();
            config.plugins.enableDevLogging();
            config.vue.vueAppName = "app";
        });

        sourceController.routes(javalin);
        quoteController.routes(javalin);

        javalin.get("/", new VueComponent("index"));
        javalin.get("/add-quote", new VueComponent("add-quote"));
        javalin.start();
    }
}