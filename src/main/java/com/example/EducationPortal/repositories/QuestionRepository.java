package com.example.EducationPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eduPortal.models.Question;
import ru.eduPortal.models.User;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> { List<Question> findAllByUser(User user);
    List<Question> findAllByUser1(User user); Optional<Question> findById(Long id);
}

