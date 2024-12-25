package com.example.EducationPortal.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.eduPortal.models.User;

import java.util.Date;


@Data @AllArgsConstructor @NoArgsConstructor public class ChatForm {
    private String message; private Date date; private Long id_course;
}
