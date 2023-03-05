package com.nnpia.cv01.repositories;

import com.nnpia.cv01.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}