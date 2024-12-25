package com.example.EducationPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eduPortal.models.Chat;
import ru.eduPortal.models.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> { List<ChatMessage> findAllByChat(Chat chat);
    List<ChatMessage> findAll();

}

