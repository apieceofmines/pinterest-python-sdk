package com.example.family.controller;

import com.example.family.entity.TrackingEventEntity;
import com.example.family.service.TrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    private final TrackingService trackingService;

    public EventsController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping
    public ResponseEntity<List<TrackingEventEntity>> getAllEvents() {
        return ResponseEntity.ok(trackingService.findAll());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<TrackingEventEntity>> getEventsByType(@PathVariable String type) {
        return ResponseEntity.ok(trackingService.findByType(type));
    }
}
