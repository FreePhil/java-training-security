package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("events")
public class Event {

    @Id private Long id;
    private String name;
    private String description;
    private LocalDateTime startRegistrationDateTime;

    @Version private Long version;
    @CreatedBy private String createdBy;
    @CreatedDate private LocalDateTime createdDate;
    @LastModifiedBy private String lastModifiedBy;
    @LastModifiedDate private LocalDateTime lastModifiedDate;

    public Event(String name, String description, LocalDateTime startRegistrationDateTime) {
        this.name = name;
        this.description = description;
        this.startRegistrationDateTime = startRegistrationDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartRegistrationDateTime() {
        return startRegistrationDateTime;
    }
}
