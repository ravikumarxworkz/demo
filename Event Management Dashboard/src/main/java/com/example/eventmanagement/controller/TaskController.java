package com.example.eventmanagement.controller;

import com.example.eventmanagement.enums.TaskStatus;
import com.example.eventmanagement.model.Task;
import com.example.eventmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
	}

	@GetMapping("/event/{eventId}")
	public List<Task> getTasksByEventId(@PathVariable Long eventId) {
		return taskService.getTasksByEventId(eventId);
	}

	@PutMapping("/{id}/status")
	public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatus status) {
		Task updatedTask = taskService.updateTaskStatus(id, status);
		return ResponseEntity.ok(updatedTask);
	}
}
