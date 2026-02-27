package com.example.family.client;

import com.example.family.model.TrackingEvent;
import com.example.family.model.TrackingResponse;

import java.time.Instant;
import java.util.HashMap;

public class ExampleClient {
    public static void main(String[] args) throws Exception {
        String base = "http://localhost:8080";
        String trackingId = "549768018410";

        TrackingClient client = new TrackingClient(base, trackingId);

        TrackingEvent e = new TrackingEvent();
        e.setType("play");
        e.setTimestamp(Instant.now());
        HashMap<String, String> meta = new HashMap<>();
        meta.put("level", "1");
        e.setMetadata(meta);

        TrackingResponse resp = client.track(e);
        System.out.println("Server acknowledged: trackingId=" + resp.getTrackingId() + " eventId=" + resp.getEventId());
    }
}
