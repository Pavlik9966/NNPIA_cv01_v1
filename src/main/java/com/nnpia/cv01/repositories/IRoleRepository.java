package com.nnpia.cv01.repositories;

import com.nnpia.cv01.domain.AppUser;
import com.nnpia.cv01.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}