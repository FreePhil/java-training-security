package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.Set;

public class Register {
    int id;

    private AggregateReference<Event, Long> event;
    private Set<QuestionResult> questionResults;
}
