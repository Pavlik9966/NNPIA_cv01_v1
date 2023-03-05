package com.nnpia.cv01.controllers;

import com.nnpia.cv01.domain.AppUser;
import com.nnpia.cv01.repositories.IAppUserRepository;
import com.nnpia.cv01.repositories.IRoleRepository;
import com.nnpia.cv01.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AppUserController {
    private final IAppUserRepository appUserRepository;
    private final IRoleRepository roleRepository;
    private final ITaskRepository taskRepository;

    @GetMapping("users/active")
    public List<AppUser> helloWorldActiveUsers() {
        return appUserRepository.findByActive(true);
    }

    @GetMapping("users/role")
    public List<AppUser> helloWorldUsersByRole() {
        return appUserRepository.findAppUsersByRole(roleRepository.findRoleByName("role1"));
    }
}