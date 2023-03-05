package com.nnpia.cv01.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/*
 * create:      Hibernate first drops existing tables, then creates new tables.
 * create-drop: Similar to create, with the addition that Hibernate will drop the database
 *              after all operations are completed. Typically used for unit testing.
 * none:        This value effectively turns off the DDL generation.
 * update:      The object model created based on the mappings (annotations or XML) is compared
 *              with the existing schema, and then Hibernate updates the schema according to the diff.
 *              It never deletes the existing tables or columns even if they are no more required by the application
 * validate:    Hibernate only validates whether the tables and columns exist, otherwise it throws an exception.
 * */

@Data
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean active;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private List<Task> tasks = Collections.emptyList();

    @JsonManagedReference
    @ManyToMany(mappedBy = "users")
    private List<Role> roles = Collections.emptyList();
}