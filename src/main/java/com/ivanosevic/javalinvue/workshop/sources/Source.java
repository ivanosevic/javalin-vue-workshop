package com.ivanosevic.javalinvue.workshop.sources;

import java.time.Instant;

public record Source(Integer id, String name, Instant createdAt) {
}
