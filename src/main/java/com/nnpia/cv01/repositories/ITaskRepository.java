package com.nnpia.cv01.repositories;

import com.nnpia.cv01.domains.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByAuthorId(final Long id);
}