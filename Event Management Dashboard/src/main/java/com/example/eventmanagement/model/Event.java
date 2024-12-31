package com.example.eventmanagement.model;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String location;
	private LocalDate date;

	@ManyToMany
	private List<Attendee> attendees;

	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Task> tasks;

	// Getters and setters
}
