package com.nnpia.cv01.controllers;

import com.nnpia.cv01.services.ResourceNotFoundException;
import com.nnpia.cv01.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/task")
@RestController
public class TaskController {
    private final TaskService taskService;

    @GetMapping("")
    public ResponseEntity<?> getAllTasks() {
        var result = taskService.findAllTasks();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable final Long id) throws ResourceNotFoundException {
        var result = taskService.findTaskById(id);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAllTasksByAppUserId(@PathVariable final Long id) {
        var result = taskService.findAllTasksByAppUserId(id);

        return ResponseEntity.ok(result);
    }
}