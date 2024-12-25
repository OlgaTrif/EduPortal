package com.example.EducationPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.eduPortal.forms.ChatForm;
import ru.eduPortal.forms.UserForm; import ru.eduPortal.forms.UserProfileForm; import ru.eduPortal.models.ChatMessage; import ru.eduPortal.services.ChatService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
public class MessageController { @Autowired
ChatService chatService; @GetMapping("/chat")
public List<ChatMessage> getAllMessage() {
    return chatService.findAllMessage();
}

    @GetMapping("/messagechat")
    public List<ChatMessage> getAllMessageChatById(ServletRequest servletRequest) { HttpServletRequest request = (HttpServletRequest) servletRequest;
        return chatService.findAllMessageByIdCourse(Long.parseLong(request.getParameter("id")));
    }

    @PostMapping("/addMessage")
    public boolean addMessage(@RequestBody ChatForm chatForm,ServletRequest servletRequest) { HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token"); chatService.addMessage(chatForm,token); return true;
    }
}

