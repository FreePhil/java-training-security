package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.futurework.Question;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query("select * from questions where event_id = :event_id")
    Collection<Question> findQuestionsByEventId(@Param("event_id") Long eventId);
}
