package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.Set;

public class Register {
    @Id int id;

    private Attendee attendee;
    private AggregateReference<Event, Long> event;
    private Set<Response> responses;
}
