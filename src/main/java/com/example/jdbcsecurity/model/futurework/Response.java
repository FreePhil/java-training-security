package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

public class Response {
    @Id int id;
    private AggregateReference<Question, Long> question;
    String reply;
}
