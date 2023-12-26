package com.example.jdbcsecurity;

import com.example.jdbcsecurity.model.futurework.Event;
import com.example.jdbcsecurity.model.futurework.Question;
import com.example.jdbcsecurity.model.futurework.QuestionType;
import com.example.jdbcsecurity.repository.EventRepository;
import com.example.jdbcsecurity.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EventAggregateTest {
    Logger logger = LoggerFactory.getLogger(EventAggregateTest.class);

    @Autowired
    private EventRepository events;

    @Test
    void testFindByName() {
        // arrange
        Event event = new Event("findname1", "description", LocalDateTime.now());

        // act
        events.save(event);

        // assert
        var eventsWithName1 = events.findByName("findname1");
        assertThat(eventsWithName1.size()).isEqualTo(1);

        Event savedEvent = eventsWithName1.get(0);
        assertThat(savedEvent.getName()).isEqualTo("findname1");
        assertThat(savedEvent.getDescription()).isEqualTo("description");
    }

    @Test
    void testFindFirstByName() {
        // arrange
        Event event = new Event("findname2", "finddescription2", LocalDateTime.now());

        // act
        events.save(event);

        // assert
        Event firstEvent = events.findFirstByName("findname2").orElseThrow();
        assertThat(firstEvent.getName()).isEqualTo("findname2");
        assertThat(firstEvent.getDescription()).isEqualTo("finddescription2");
    }
}
