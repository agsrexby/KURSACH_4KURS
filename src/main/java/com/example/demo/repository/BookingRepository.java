package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("""
        SELECT b FROM Booking b
        WHERE b.computer.id = :computerId
        AND b.endTime > :start
        AND b.startTime < :end
    """)
    List<Booking> findConflicts(Long computerId,
                               LocalDateTime start,
                               LocalDateTime end);
}