package com.example.EducationPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eduPortal.models.Chat;
import ru.eduPortal.models.ChatMessage;
import ru.eduPortal.models.Course;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Long> { List<Chat> findAll();
    Chat findById(Long id);
    Chat findByCourse_Id(Long id); Chat findByCourse(Course course);

}

