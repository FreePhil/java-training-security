package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Event {

    private @Id Long id;

    private String name;
    private String description;
    private LocalDateTime startRegistrationDate;
    private LocalDateTime lastRegistrationDate;

    private Set<Question> survey = new HashSet<>();

    private Event addQuestion(int sequence, String description, int type) throws Exception {
        var question = new Question(sequence, description, type, null);
        survey.add(question);

        return this;
    }
}
