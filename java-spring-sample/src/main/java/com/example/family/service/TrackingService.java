package com.example.family.service;

import com.example.family.entity.TrackingEventEntity;
import com.example.family.model.TrackingEvent;
import com.example.family.model.TrackingResponse;
import com.example.family.repository.TrackingEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TrackingService {
    private static final Logger log = LoggerFactory.getLogger(TrackingService.class);

    // Provided tracking/analytics ID
    public static final String TRACKING_ID = "549768018410";

    private final TrackingEventRepository repository;

    public TrackingService(TrackingEventRepository repository) {
        this.repository = repository;
    }

    public TrackingResponse track(TrackingEvent event) {
        // enrich event
        String eventId = UUID.randomUUID().toString();
        Instant now = Instant.now();
        event.setId(eventId);
        if (event.getTimestamp() == null) {
            event.setTimestamp(now);
        }

        // Save to database
        TrackingEventEntity entity = new TrackingEventEntity(
                eventId, event.getType(), TRACKING_ID, event.getTimestamp(), event.getMetadata()
        );
        repository.save(entity);

        log.info("Tracked event id={} type={} trackingId={} metadata={}",
                eventId, event.getType(), TRACKING_ID, event.getMetadata());

        return new TrackingResponse(TRACKING_ID, eventId, now);
    }

    public List<TrackingEventEntity> findByType(String type) {
        return repository.findByType(type);
    }

    public List<TrackingEventEntity> findAll() {
        return repository.findAll();
    }
}
