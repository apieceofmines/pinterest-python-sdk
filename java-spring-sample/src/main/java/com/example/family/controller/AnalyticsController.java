package com.example.family.controller;

import com.example.family.model.TrackingEvent;
import com.example.family.model.TrackingResponse;
import com.example.family.service.TrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AnalyticsController {

    private final TrackingService trackingService;

    public AnalyticsController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/track")
    public ResponseEntity<TrackingResponse> track(@RequestBody TrackingEvent event) {
        TrackingResponse response = trackingService.track(event);
        return ResponseEntity.ok(response);
    }
}
