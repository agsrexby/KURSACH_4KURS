package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ComputerRepository computerRepository;

    public Booking createBooking(Long userId,
                                 Long computerId,
                                 LocalDateTime start,
                                 LocalDateTime end) {

        if (!bookingRepository.findConflicts(computerId, start, end).isEmpty()) {
            throw new RuntimeException("Компьютер уже забронирован");
        }

        User user = userRepository.findById(userId).orElseThrow();
        Computer computer = computerRepository.findById(computerId).orElseThrow();

        Booking booking = Booking.builder()
                .user(user)
                .computer(computer)
                .startTime(start)
                .endTime(end)
                .build();

        return bookingRepository.save(booking);
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public Booking getById(Long id) {
    return bookingRepository.findById(id).orElseThrow();
}

public Booking updateBooking(Long id,
                             LocalDateTime start,
                             LocalDateTime end) {

    Booking booking = bookingRepository.findById(id).orElseThrow();

    if (!bookingRepository.findConflicts(
            booking.getComputer().getId(),
            start,
            end
    ).isEmpty()) {
        throw new RuntimeException("Компьютер уже забронирован");
    }

    booking.setStartTime(start);
    booking.setEndTime(end);

    return bookingRepository.save(booking);
}

public void delete(Long id) {
    bookingRepository.deleteById(id);
}
}
