package com.example.EducationPortal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import ru.eduPortal.forms.CourseForm;
import ru.eduPortal.forms.CourseUserForm; import ru.eduPortal.forms.StageForm; import ru.eduPortal.forms.UserForm; import ru.eduPortal.models.Course;
import ru.eduPortal.models.Stage;
import ru.eduPortal.models.User;
import ru.eduPortal.services.CourseService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) @RestController
public class CourseController { @Autowired
CourseService courseService;

    @GetMapping("/usercourse/{id}")
    public boolean checkCourseById(@PathVariable("id") Long id){
        return courseService.checkCourseUser(id);
    }
    @GetMapping("/course")
    public List<CourseForm> getCourses() {

        return courseService.findAll();
    }
    @GetMapping("/education/{id}")
    public List<Course> getCoureStudById(@PathVariable("id") Long id) {

        return courseService.findAllCourseUser(id);
    }

    @GetMapping("/course/{id}")
    public Course getCoureById(@PathVariable("id") Long id) {
        return courseService.findById(id);
    }

    @GetMapping("/course/stage/{id}")
    public List<Stage> getStageCourseById(@PathVariable("id") Long id) {

        return courseService.findAllStageById(id);
    }

    @GetMapping("/findCourseByName")
    public Course findUserByLogin(@RequestParam("course") String course) {
        return courseService.findCourseByName(course);

    }
    @GetMapping("/course/recom")
    public List<Course> getCourseRecommendations(ServletRequest servletRequest) { HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        return courseService.findAllCourseRecommen(token);
    }


    @GetMapping("/education")
    public List<Course> getCoureUser(ServletRequest servletRequest) { HttpServletRequest request = (HttpServletRequest) servletRequest; String token = request.getHeader("token");
        return courseService.findAllCourseUser(token);
    }

    @PostMapping("/addCourse")
    public long addCourse(@RequestBody Course course,ServletRequest servletRequest) { HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
//courseService.addCourse(course,token);
        return courseService.addCourse(course,token);
    }



    @GetMapping("/addCourseUser/{id}")
    public boolean addCourseUser(@PathVariable("id") Long id,ServletRequest servletRequest) { HttpServletRequest request = (HttpServletRequest) servletRequest;

// Long l=Long.parseLong(request.getParameter("id")); String token = request.getHeader("token"); System.out.println(id);
        return courseService.addCourseUser(id,token);
    }

    @PostMapping("/addStageCourse")
    public ResponseEntity<Object> addStage(@RequestBody StageForm stage) {
        courseService.addStage(stage); return ResponseEntity.ok().build();
    }

}
