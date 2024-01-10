package com.example.jdbcsecurity.repository;

import com.example.jdbcsecurity.model.futurework.Question;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface QuestionRepository extends CrudRepository<Question, Long>, VersionedQuestionRepository {
}
