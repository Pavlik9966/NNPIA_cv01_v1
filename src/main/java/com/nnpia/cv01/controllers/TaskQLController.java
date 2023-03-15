package com.nnpia.cv01.controllers;

import com.nnpia.cv01.domains.AppUser;
import com.nnpia.cv01.domains.Task;
import com.nnpia.cv01.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskQLController {
    private final TaskService taskService;

    @SchemaMapping("AppUser")
    public List<Task> getTasksByAppUser(final AppUser appUser) {
        return taskService.findAllTasksByAppUserId(appUser.getId());
    }
}