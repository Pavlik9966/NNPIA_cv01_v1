package com.nnpia.cv01.repositories;

import com.nnpia.cv01.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}