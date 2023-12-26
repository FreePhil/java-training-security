package com.example.jdbcsecurity.model.futurework;

import org.springframework.data.annotation.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table("events")
public class Event {

    private @Id Long id;
    private String name;
    private String description;
//    private String location;
    private LocalDateTime startRegistrationDateTime;
//    private LocalDateTime endRegistrationDateTime;
//    private LocalDateTime startEventDateTime;
//    private LocalDateTime endEventDateTime;

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

    //    private Set<AggregateReference<Register, Long>> registers = new HashSet<>();

}
