package com.example.EducationPortal.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Token { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id; private String value;

    @ManyToOne @JoinColumn(name = "user_id") private User user;
}

