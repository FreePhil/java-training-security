package com.example.jdbcsecurity.model.futurework;


import org.springframework.data.relational.core.mapping.Table;

@Table("question_options")
public class QuestionOption {
    int sequence;
    String description;
}
