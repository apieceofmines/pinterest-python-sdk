package com.example.family.repository;

import com.example.family.entity.TrackingEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEventEntity, Long> {
    List<TrackingEventEntity> findByTrackingId(String trackingId);
    List<TrackingEventEntity> findByType(String type);
    List<TrackingEventEntity> findByTimestampBetween(Instant startTime, Instant endTime);
}
