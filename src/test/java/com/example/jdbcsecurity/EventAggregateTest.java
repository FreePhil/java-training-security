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

    @Autowired
    private QuestionRepository questions;

    @Test
    void testAddEvent() {
//        // arrange
//        Event event = new Event("name", "description", LocalDateTime.now());
//        event.addQuestion(1, "question1", QuestionType.Choice);
//        event.addQuestion(2, "question2", QuestionType.Text);
//
//
//        // act
//        events.save(event);
//
//        // assert
//        var persisted = events.findById(event.getId()).orElse(null);
//        assertThat(persisted).isNotNull();
//        assertThat(persisted.getSurvey().size()).isEqualTo(2);
    }

    @Test
    void testFindName() {
//        // arrange
//        Event event = new Event("name1", "description", LocalDateTime.now());
//        event.addQuestion(1, "question1", QuestionType.Text);
//        event.addQuestion(2, "question2", QuestionType.Choice);
//
//
//        // act
//        events.save(event);
//
//        // assert
//        var name1Events = events.findByName(event.getName());
//        assertThat(name1Events.size()).isEqualTo(1);
    }

//    @Test
//    void testUpdateQuestion() {
//        // arrange
//        Event event = new Event("name1", "description", LocalDateTime.now());
//        event.addQuestion(1, "question1", QuestionType.Text);
//        event.addQuestion(2, "question2", QuestionType.Choice);
//        events.save(event);
//        int updateCount = events.updateQuestion(event.getId(), 2, "QUESTION3" , QuestionType.Text);
//
//        // assert
//        assertThat(updateCount).isEqualTo(1);
//    }

    @Test
    void testRetrieveQuestionFromEvent() throws InterruptedException {
        // arrange
        Event event = new Event("name", "description", LocalDateTime.now());
        events.save(event);
        Question q1 = new Question(1, "question1", QuestionType.Choice, AggregateReference.to(event.getId()));
        Question q2 = new Question(2, "question2", QuestionType.Text, AggregateReference.to(event.getId()));
        questions.save(q1);
        questions.save(q2);

        //act
        Collection<Question> setOfQuestions = questions.findQuestionsByEventId(event.getId());


        //assert
        assertThat(setOfQuestions.size()).isEqualTo(2);
    }
}
