package com.example.EducationPortal.models;

import lombok.*;

import javax.persistence.*; @Data @NoArgsConstructor @AllArgsConstructor @Builder

@Entity
@Table(name = "course_user") public class CourseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id") private Course course;


    @ManyToOne @JoinColumn(name = "user_id") private User user;


    @Override
    public String toString() {
        return null;
    }
}

