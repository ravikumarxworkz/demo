package com.example.eventmanagement.repository;

import com.example.eventmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByEventId(Long eventId);
}

