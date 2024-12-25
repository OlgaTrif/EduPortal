package com.example.EducationPortal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter @Setter
@NoArgsConstructor

@AllArgsConstructor @Builder
@Entity
@Table(name = "public_user") public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName; private String lastName; private Integer age; private String login;
    private String hashPassword; private String email;

    /* @ManyToOne @JoinColumn(name = "role_id")*/
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "user") List<Chat> chats;

    @OneToMany(mappedBy = "user") List<ChatMessage> chatMessages;

    @OneToMany(mappedBy = "user") @JsonIgnore
    List<ChatUser> chatUsers ;

    @OneToMany(mappedBy = "user") @JsonIgnore
    private List<CourseUser> courseUsers;

    @OneToMany(mappedBy = "user") @JsonIgnore
    private List<CoursesStudied> coursesStudieds;

    @OneToMany(mappedBy = "user") @JsonIgnore
    private List<Question> questions;

    /* @OneToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinTable(name = "user_course",
    joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="course_id")
    )*/
    @OneToOne(mappedBy = "user") @JsonIgnore
    private Course course;

}

