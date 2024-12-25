package com.example.EducationPortal.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "chat") public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chatName; @ManyToOne @JoinColumn(name = "user_id") private User user;

    @ManyToOne

    @JoinColumn(name = "course_id") private Course course;

    @OneToMany(mappedBy = "chat") List<ChatMessage> chatMessages;

    @OneToMany(mappedBy = "chat") List<ChatUser> chatUsers;
}

