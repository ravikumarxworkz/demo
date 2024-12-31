package com.example.eventmanagement.controller;

import com.example.eventmanagement.model.Attendee;
import com.example.eventmanagement.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {
    @Autowired
    private AttendeeService attendeeService;

    @GetMapping
    public List<Attendee> getAllAttendees() {
        return attendeeService.getAllAttendees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {
        return attendeeService.getAttendeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Attendee createAttendee(@RequestBody Attendee attendee) {
        return attendeeService.createAttendee(attendee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable Long id) {
        attendeeService.deleteAttendee(id);
        return ResponseEntity.ok().build();
    }
}

