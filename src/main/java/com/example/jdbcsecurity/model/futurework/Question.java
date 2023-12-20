package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("questions")
public class Question {

    private @Id Long id;
    private int row;
    private String description;
    private int type;
//    private List<QuestionOption> options = new ArrayList<>();

    public Question(int row, String description, int type /*, List<QuestionOption> options*/) throws Exception {
        this.row = row;
        this.description = description;
        this.type = type;
//        this.options = options;
    }
}
