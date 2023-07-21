package com.ivanosevic.javalinvue.workshop.core;

import io.javalin.Javalin;

public interface Controller {
    void routes(Javalin javalin);
}
