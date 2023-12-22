package com.example.jdbcsecurity;

import com.example.jdbcsecurity.model.futurework.Event;
import com.example.jdbcsecurity.model.futurework.Question;
import com.example.jdbcsecurity.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EventAggregateTest {
    Logger logger = LoggerFactory.getLogger(EventAggregateTest.class);

    @Autowired
    private EventRepository events;

    @Test
    void testAddEvent() {
        // arrange
        Event event = new Event("name", "description", LocalDateTime.now());
        event.addQuestion(1, "question1", 1);
        event.addQuestion(2, "question2", 2);


        // act
        events.save(event);

        // assert
        var persisted = events.findById(event.getId()).orElse(null);
        assertThat(persisted).isNotNull();
        assertThat(persisted.getSurvey().size()).isEqualTo(2);
    }

    @Test
    void testFindName() {
        // arrange
        Event event = new Event("name1", "description", LocalDateTime.now());
        event.addQuestion(1, "question1", 1);
        event.addQuestion(2, "question2", 2);


        // act
        events.save(event);

        // assert
        var name1Events = events.findByName(event.getName());
        assertThat(name1Events.size()).isEqualTo(1);
    }

    @Test
    void testRetrieveQuestionFromEvent() throws InterruptedException {
        // arrange
        Event event = new Event("name", "description", LocalDateTime.now());
        event.addQuestion(1, "question1", 1);
        event.addQuestion(2, "question2", 2);
        events.save(event);

        event.addQuestion(3, "question3", 3);
        events.save(event);

//         events.updateQuestion(event.getId(), 3, "question4", 4);
        Thread.sleep(2000);

        //act
        event.getSurvey().stream()
                .filter(question -> question.getRowNo() == 3)
                .findFirst().ifPresent(question -> {
                    question.setDescription("question4");
                    question.setType(4);
                });
//        Question question = events.findQuestionById(event.getId(), 2).orElse(null);
        events.save(event);

        //assert
        var question = events.findQuestionById(event.getId(), 2).orElse(null);

        assertThat(question).isNotNull();
        assertThat(question.getRowNo()).isEqualTo(2);
        assertThat(question.getDescription()).isEqualTo("question2");
        assertThat(question.getType()).isEqualTo(2);
    }
}
