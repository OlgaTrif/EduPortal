package com.example.EducationPortal.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor public class CourseForm {
    private Long id;
    private String nameCourse; private String description; private String avtor; private Integer cost; private String image; private Long id_user;
}
