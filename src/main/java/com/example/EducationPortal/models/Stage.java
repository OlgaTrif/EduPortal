package com.example.EducationPortal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "stage")

public class Stage { @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String nameStage; private String video;

    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "course_id")
    private Course course;

}

