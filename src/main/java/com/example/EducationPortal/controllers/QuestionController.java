package com.example.EducationPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.eduPortal.forms.AnswerForm; import ru.eduPortal.forms.QuestionForm; import ru.eduPortal.models.Question;
import ru.eduPortal.services.QuestionService;
import ru.eduPortal.services.UserService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) @RestController
@RequestMapping
public class QuestionController { @Autowired
private UserService userService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/postAnswer")
    public boolean postQuestion(@RequestBody AnswerForm answerForm,ServletRequest servletRequest)
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest; String token = request.getHeader("token");
        return questionService.addQuestion(answerForm,token);
    }

    @PostMapping("/addAnswer")
    public boolean addAnswer(@RequestBody AnswerForm answerForm)
    {
        return userService.addAnswer(answerForm);
    }


    @GetMapping("/questionsanswers")
    public List<QuestionForm> getQuestionAndAnswers(@RequestParam("teacherid") Long teacherId) {
        return questionService.findAllQuestionAndAnswer(teacherId);
    }

    @GetMapping("/questionsstudent")
    public List<QuestionForm> getQuestionStudent(@RequestParam("studentid") Long studentid) {
        return questionService.findAllQuestionAndAnswerByUser(studentid);
    }

}
