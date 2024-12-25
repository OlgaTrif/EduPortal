package com.example.EducationPortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.eduPortal.models.Course;
import ru.eduPortal.models.CoursesStudied;
import ru.eduPortal.models.User;

import java.util.List;

public interface CourseStudRepository extends JpaRepository<CoursesStudied,Long>{ List<CoursesStudied> findAllByUser(User user);
}
