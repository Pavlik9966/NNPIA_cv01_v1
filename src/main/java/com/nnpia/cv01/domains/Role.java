package com.nnpia.cv01.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    private Long id;

    @Column
    private String name;

    @JoinTable(
            name = "app_user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "app_user_id")
    )
    @JsonBackReference
    @ManyToMany
    private List<AppUser> users = Collections.emptyList();
}