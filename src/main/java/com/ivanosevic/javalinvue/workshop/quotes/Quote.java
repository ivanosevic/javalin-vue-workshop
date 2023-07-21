package com.ivanosevic.javalinvue.workshop.quotes;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record Quote(Integer id, String content, String source,
                    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime localDateTime) {

}
