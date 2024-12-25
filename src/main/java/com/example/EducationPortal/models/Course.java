package com.example.EducationPortal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString @Entity
@Table(name = "course") public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCourse; private String description; private String avtor; private Integer cost; private String image;

    @OneToMany(mappedBy = "course") private List<Stage> stages;

    @OneToMany(mappedBy = "course")
    private List<CoursesStudied> coursesStudieds;

    @OneToMany(mappedBy = "course") private List<CourseUser> courseUsers;

    @OneToMany(mappedBy = "course") private List<Chat> chats;

/*@OneToOne(mappedBy = "course") @JsonIgnore
private User user;*/

    @OneToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "user_course",
            joinColumns = @JoinColumn(name="course_id"), inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private User user;


    @Override
    public String toString() {
        return null;
    }

}
