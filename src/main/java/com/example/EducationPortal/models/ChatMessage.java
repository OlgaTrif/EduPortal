package com.example.EducationPortal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "chat_message") public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message; private Date date;

    @ManyToOne @JoinColumn(name = "user_id") private User user;

    @ManyToOne @JoinColumn(name = "chat_id") private Chat chat;


}

