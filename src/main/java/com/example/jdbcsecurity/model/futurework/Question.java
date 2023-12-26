package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("questions")
public class Question {

    private @Id Long id;
    private int rowNo;
    private String description;
    private QuestionType type;

    private @Column("event_id") AggregateReference<Event, Long> event;

    @Version
    private Long version;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public Question(int rowNo, String description, QuestionType type, AggregateReference<Event, Long> event) {
        this.event = event;
        this.rowNo = rowNo;
        this.description = description;
        this.type = type;
        this.event = event;
    }

    public Long getId() {
        return id;
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

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }


}
