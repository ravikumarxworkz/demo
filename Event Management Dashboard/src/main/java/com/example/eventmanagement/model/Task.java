package com.example.eventmanagement.model;

import javax.persistence.*;

import com.example.eventmanagement.enums.TaskStatus;

import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate deadline;
	private TaskStatus status;

	@ManyToOne
	private Event event;

	@ManyToOne
	private Attendee assignedAttendee;

	// Getters and setters
}
