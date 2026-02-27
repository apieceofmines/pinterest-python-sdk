package com.example.family.client;

import com.example.family.model.TrackingEvent;
import com.example.family.model.TrackingResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TrackingClient {
    private final HttpClient httpClient;
    private final ObjectMapper mapper;
    private final String baseUrl;
    private final String trackingId;

    public TrackingClient(String baseUrl, String trackingId) {
        this.httpClient = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length()-1) : baseUrl;
        this.trackingId = trackingId;
    }

    public TrackingResponse track(TrackingEvent event) throws IOException, InterruptedException {
        String url = baseUrl + "/api/track";
        String body = mapper.writeValueAsString(event);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "applicat, trackingId)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> resp = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (resp.statusCode() >= 200 && resp.statusCode() < 300) {
            return mapper.readValue(resp.body(), TrackingResponse.class);
        }
        throw new IOException("Unexpected response: " + resp.statusCode() + " body=" + resp.body());
    }
}
