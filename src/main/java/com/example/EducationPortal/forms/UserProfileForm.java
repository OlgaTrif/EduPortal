package com.example.EducationPortal.forms;

import lombok.Data;
import ru.eduPortal.models.Course;
import java.util.List;

@Data
public class UserProfileForm {
    private Long id;
    private String firstName; private String lastName; private String login; private Integer age;

    private String email;
}
