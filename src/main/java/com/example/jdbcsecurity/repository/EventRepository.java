package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.futurework.Event;
import com.example.jdbcsecurity.model.futurework.Question;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, Long> {

    @Query("select * from questions where event_id = :event_id and row_no = :rowNo")
    Optional<Question> findQuestionById(@Param("event_id") Long id, int rowNo);

    @Modifying
    @Query("update questions set description = :description, type = :type where event_id = :event_id and row_no = :row_no")
    void updateQuestion(@Param("event_id") Long id, @Param("row_no") int rowNo, @Param("description") String description, @Param("type")int type);

    List<Event> findByName(String name);
}
