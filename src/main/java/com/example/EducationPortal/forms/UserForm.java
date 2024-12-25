package com.example.EducationPortal.forms;

import lombok.Data;
import ru.eduPortal.models.Role;

@Data
public class UserForm { private String firstName; private String lastName; private String login; private Integer age; private String password; private String email; private Integer role_id;
}

