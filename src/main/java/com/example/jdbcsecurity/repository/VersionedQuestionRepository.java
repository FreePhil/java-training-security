package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.futurework.Event;
import com.example.jdbcsecurity.model.futurework.Question;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.util.List;

public interface VersionedQuestionRepository {
    List<Question> findUpdatedQuestionByEventId(AggregateReference<Event, Long> eventId);
}
