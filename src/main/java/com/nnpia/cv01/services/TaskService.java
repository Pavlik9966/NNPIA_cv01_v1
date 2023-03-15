package com.nnpia.cv01.services;

import com.nnpia.cv01.domains.Task;
import com.nnpia.cv01.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final ITaskRepository taskRepository;

    public List<Task> findAllTasksByAppUserId(final Long id) {
        return taskRepository.findAllByAuthorId(id);
    }
}