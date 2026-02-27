package com.example.family.service;

import com.example.family.model.TrackingEvent;
import com.example.family.model.TrackingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class TrackingService {
    private static final Logger log = LoggerFactory.getLogger(TrackingService.class);

    // Provided tracking/analytics ID
    public static final String TRACKING_ID = "549768018410";

    public TrackingResponse track(TrackingEvent event) {
        // enrich event
        String eventId = UUID.randomUUID().toString();
        Instant now = Instant.now();
        event.setId(eventId);
        if (event.getTimestamp() == null) {
            event.setTimestamp(now);
        }

        // In a real app we'd persist or forward this event. For this sample, log it.
        log.info("Tracked event id={} type={} trackingId={} metadata={}",
                eventId, event.getType(), TRACKING_ID, event.getMetadata());

        return new TrackingResponse(TRACKING_ID, eventId, now);
    }
}
