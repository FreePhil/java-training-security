package com.example.jdbcsecurity;

import com.example.jdbcsecurity.model.Post;
import com.example.jdbcsecurity.model.futurework.Event;
import com.example.jdbcsecurity.repository.EventRepository;
import com.example.jdbcsecurity.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Configuration
public class EventAggregateTest {
    Logger logger = LoggerFactory.getLogger(EventAggregateTest.class);

    @Autowired
    private EventRepository events;

    @Test
    void testAddEvent() {
        // arrange
        Event event = new Event("name", "description", LocalDateTime.now());


        // act
        events.save(event);

        // assert
        assertThat(event.getId()).isNotNegative();
    }
}
