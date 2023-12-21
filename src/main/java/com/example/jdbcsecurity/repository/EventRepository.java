package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.futurework.Event;
import com.example.jdbcsecurity.model.futurework.Question;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, Long> {

    @Query("select * from events join questions on events.id = questions.event_id where events.id = :id and questions.row_no = :rowNo")
    Optional<Question> findQuestionById(Long id, int rowNo);
}
