package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookingRequest {
    private Long userId;
    private Long computerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}