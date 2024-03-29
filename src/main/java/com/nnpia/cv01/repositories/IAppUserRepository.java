package com.nnpia.cv01.repositories;

import com.nnpia.cv01.domains.AppUser;
import com.nnpia.cv01.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByUsername(String username);

    List<AppUser> findByActive(boolean active);

    @Query("select au from AppUser au join au.roles r where r = :role")
    List<AppUser> findUsersByRole(Role role);
}