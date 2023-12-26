package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.futurework.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, Long> {
}
