package com.ivanosevic.javalinvue.workshop.sources;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Optional;

public class SourceService {

    private final Jdbi jdbi;

    public SourceService(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<Source> findAll() {
        try (Handle handle = jdbi.open()) {
            SourceDao sourceDao = handle.attach(SourceDao.class);
            return sourceDao.findAll();
        }
    }

    public Optional<Source> findByName(String name) {
        try (Handle handle = jdbi.open()) {
            SourceDao sourceDao = handle.attach(SourceDao.class);
            return sourceDao.findByName(name);
        }
    }
}
