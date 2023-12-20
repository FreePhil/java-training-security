package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.futurework.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
