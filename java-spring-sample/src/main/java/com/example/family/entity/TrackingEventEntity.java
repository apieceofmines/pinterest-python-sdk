package com.example.family.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Map;

@Entity
@Table(name = "tracking_events")
public class TrackingEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventId;
    private String type;
    private String trackingId;
    private Instant timestamp;
    private Instant createdAt;

    @ElementCollection
    private Map<String, String> metadata;

    public TrackingEventEntity() {
    }

    public TrackingEventEntity(String eventId, String type, String trackingId, Instant timestamp, Map<String, String> metadata) {
        this.eventId = eventId;
        this.type = type;
        this.trackingId = trackingId;
        this.timestamp = timestamp;
        this.metadata = metadata;
        this.createdAt = Instant.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getTrackingId() { return trackingId; }
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Map<String, String> getMetadata() { return metadata; }
    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }
}
