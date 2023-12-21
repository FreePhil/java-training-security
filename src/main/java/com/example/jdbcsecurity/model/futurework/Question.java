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

    public Question(int rowNo, String description, int type /*, List<QuestionOption> options*/) {
        this.rowNo = rowNo;
        this.description = description;
        this.type = type;
//        this.options = options;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
