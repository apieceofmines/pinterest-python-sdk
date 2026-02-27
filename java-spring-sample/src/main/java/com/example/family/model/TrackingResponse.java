package com.example.family.model;

import java.time.Instant;

public class TrackingResponse {
    private String trackingId;
    private String eventId;
    private Instant receivedAt;

    public TrackingResponse() {
    }

    public TrackingResponse(String trackingId, String eventId, Instant receivedAt) {
        this.trackingId = trackingId;
        this.eventId = eventId;
        this.receivedAt = receivedAt;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Instant getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Instant receivedAt) {
        this.receivedAt = receivedAt;
    }
}
