package com.nnpia.cv01.services;

import com.nnpia.cv01.domains.Task;
import com.nnpia.cv01.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final ITaskRepository taskRepository;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findAllTasksByAppUserId(final Long id) {
        return taskRepository.findAllByAuthorId(id);
    }

    public Task findTaskById(final Long id) throws ResourceNotFoundException {
        Optional<Task> result = taskRepository.findById(id);

        if (result.isEmpty()) throw new ResourceNotFoundException();

        return result.get();
    }
}