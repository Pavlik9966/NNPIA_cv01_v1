package com.nnpia.cv01.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @JoinColumn(name = "author_id")
    @JsonBackReference
    @ManyToOne
    private AppUser author;
}