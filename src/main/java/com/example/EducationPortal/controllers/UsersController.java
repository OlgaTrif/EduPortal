package com.example.EducationPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.*; import ru.eduPortal.forms.QuestionForm;
import ru.eduPortal.forms.UserForm; import ru.eduPortal.forms.UserProfileForm; import ru.eduPortal.models.User;
import ru.eduPortal.services.UserService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) @RestController
@RequestMapping
public class UsersController { @Autowired
private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.findAll();
    }
    @GetMapping("/questions")
    public List<QuestionForm> getQuestion(@RequestParam("teacherid") Long teacherId) {
        return userService.findAllQuestion(teacherId);
    }
    @GetMapping("/users/{user-id}")
    public User getUser(@PathVariable("user-id") Long userId) {
        return userService.findOne(userId);
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody UserForm userForm) {
        return userService.signUp(userForm);
    }

    @GetMapping("/findUserByLogin")
    public User findUserByLogin(@RequestParam("login") String login) {
        return userService.findByLogin(login);

    }
    @PostMapping("/userUpdate")
    public boolean updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }


    @GetMapping("/checkAdmin")
    public boolean checkAdmin(@RequestParam("login") String login) {

        return userService.checkAdmin(login);
    }
    @GetMapping("/checkTeacher")
    public boolean checkTeacher(@RequestParam("login") String login) {

        return userService.checkTeachet(login);
    }


    @GetMapping("/users/info")
    public UserProfileForm getUserByInfo(ServletRequest servletRequest) { HttpServletRequest request = (HttpServletRequest) servletRequest; String token = request.getHeader("token");
        return userService.findByIdAndToken(token);
    }
}
