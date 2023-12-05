package com.example.jdbcsecurity.model.futurework;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int sequence;
    private String description;
    private int type;
    private List<String> options = new ArrayList<>();

    public Question(int sequence, String description, int type, List<String> options) throws Exception {
        this.sequence = sequence;
        this.description = description;
        this.type = type;
        this.options = options;
    }
}
