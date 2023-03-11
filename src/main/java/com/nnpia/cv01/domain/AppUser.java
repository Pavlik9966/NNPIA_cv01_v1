package com.nnpia.cv01.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@NoArgsConstructor
@Table(name = "app_user")
public class AppUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    @NotBlank
    @NotNull
    @Size(max = 255, min = 1)
    private String username;

    @Column
    private String password;

    @Column
    private Boolean active;

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

    public AppUser(Long id, String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public AppUser(String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
}