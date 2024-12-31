package com.example.eventmanagement.model;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToMany(mappedBy = "attendees")
    private List<Event> events;

    @OneToMany(mappedBy = "assignedAttendee")
    private List<Task> tasks;

    // Getters and setters
}

