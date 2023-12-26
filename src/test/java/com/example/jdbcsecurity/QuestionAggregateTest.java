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
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuestionAggregateTest {

    Logger logger = LoggerFactory.getLogger(QuestionAggregateTest.class);

    @Autowired
    private EventRepository events;

    @Autowired
    private QuestionRepository questions;

    @Test
    public void testCreateQuestion() {
        // arrange
        Question q1 = new Question(1, "question1", QuestionType.Choice, null);

        // act
        questions.save(q1);

        // assert
        Question q2 = questions.findById(q1.getId()).orElse(null);
        assertThat(q2).isNotNull();
        assertThat(q2.getType()).isEqualTo(QuestionType.Choice);
    }

    @Test
    public void testUpdateQuestion() {
        // arrange
        Question q1 = new Question(1, "question1", QuestionType.Choice, null);
        questions.save(q1);

        // act
        q1.setType(QuestionType.Text);
        q1.setDescription("new description");
        questions.save(q1);

        // assert
        Question q2 = questions.findById(q1.getId()).orElse(null);
        assertThat(q2).isNotNull();
        assertThat(q2.getType()).isEqualTo(QuestionType.Text);
    }

    @Test
    public void testAddQuestions() {
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
