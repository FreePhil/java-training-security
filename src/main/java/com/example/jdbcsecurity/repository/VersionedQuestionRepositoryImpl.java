package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.futurework.Event;
import com.example.jdbcsecurity.model.futurework.Question;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class VersionedQuestionRepositoryImpl implements VersionedQuestionRepository{

    private JdbcTemplate template;

    public VersionedQuestionRepositoryImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Question> findUpdatedQuestionByEventId(AggregateReference<Event, Long> eventId) {
        return template.query(
                "select * from questions where event_id = ? and version > 0",
                new BeanPropertyRowMapper<Question>(Question.class),
                eventId.getId());
    }
}
