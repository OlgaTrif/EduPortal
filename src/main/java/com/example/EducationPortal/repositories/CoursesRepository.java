package com.example.EducationPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.eduPortal.models.Chat; import ru.eduPortal.models.Course; import ru.eduPortal.models.CourseUser;

import java.util.List;
import java.util.Optional;

public interface CoursesRepository extends JpaRepository<Course,Long> {

    List<Course> findAll(); Course findById(Long id);
    List<Course> findAllById(Long id);
    List<Course> findAllByCourseUsers(List<CourseUser> courseUsers); Optional<Course> findByNameCourse(String course);
}
