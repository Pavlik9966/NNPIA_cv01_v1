package com.nnpia.cv01.controllers;

import com.nnpia.cv01.repositories.IAppUserRepository;
import com.nnpia.cv01.repositories.IRoleRepository;
import com.nnpia.cv01.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AppUserController {
    private final IAppUserRepository appUserRepository;
    private final IRoleRepository roleRepository;
    private final ITaskRepository taskRepository;

    @GetMapping("users/active")
    public String helloWorldActiveUsers() {
        return appUserRepository.findByActive(true).toString();
    }

    @GetMapping("users/role")
    public String helloWorldUsersByRole() {
        return appUserRepository.findAppUsersByRole(roleRepository.findRoleByName("role1")).toString();
    }
}