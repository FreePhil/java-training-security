package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Event {

    private @Id Long id;

    private String name;
    private String description;
    private String location;
    private LocalDateTime startRegistrationDateTime;
    private LocalDateTime endRegistrationDateTime;
    private LocalDateTime startEventDateTime;
    private LocalDateTime endEventDateTime;

    private Set<Question> survey = new HashSet<>();
    private Set<AggregateReference<Register, Long>> registers;

    private Event addQuestion(int sequence, String description, int type) throws Exception {
        var question = new Question(sequence, description, type, null);
        survey.add(question);

        return this;
    }
}
