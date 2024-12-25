package com.example.EducationPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eduPortal.models.Course; import ru.eduPortal.models.CourseUser; import ru.eduPortal.models.User;

import java.util.List;
import java.util.Optional;

public interface CourseUserRepository extends JpaRepository<CourseUser,Long> { List<CourseUser> findAllByUser(User user);
    CourseUser findByCourse(Course course);
    Optional<CourseUser> findCourseUserByUserAndCourse(User user, Course course); CourseUser findByCourse_Id(Long id);
}

