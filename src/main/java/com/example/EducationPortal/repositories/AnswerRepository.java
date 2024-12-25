package com.example.EducationPortal.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.eduPortal.models.Answer;
import ru.eduPortal.models.Question;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer,Long> { List<Answer> findAllByQuestion(Question question);
    Optional<Answer> findByQuestion(Question question);
}

