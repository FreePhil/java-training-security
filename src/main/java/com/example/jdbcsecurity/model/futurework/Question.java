package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("questions")
public class Question {

    private @Id Long id;
    private int rowNo;
    private String description;
    private int type;
//    private List<QuestionOption> options = new ArrayList<>();

    public Question(int rowNo, String description, int type /*, List<QuestionOption> options*/) throws Exception {
        this.rowNo = rowNo;
        this.description = description;
        this.type = type;
//        this.options = options;
    }
}
