package com.example.EducationPortal.models;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "course_studied") public class CoursesStudied {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne @JoinColumn(name = "user_id") private User user;

    @ManyToOne
    @JoinColumn(name = "course_id") private Course course;

    @Override
    public String toString() {
        return null;
    }
}

