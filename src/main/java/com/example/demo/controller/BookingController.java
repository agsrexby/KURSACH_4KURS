package com.example.demo.controller;

import com.example.demo.dto.BookingRequest;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // GET all
    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Booking getById(@PathVariable Long id) {
        return bookingService.getById(id);
    }

    // POST
    @PostMapping
    public Booking create(@RequestBody BookingRequest request) {
        return bookingService.createBooking(
                request.getUserId(),
                request.getComputerId(),
                request.getStartTime(),
                request.getEndTime()
        );
    }

    // PUT
    @PutMapping("/{id}")
    public Booking update(@PathVariable Long id,
                          @RequestBody BookingRequest request) {
        return bookingService.updateBooking(
                id,
                request.getStartTime(),
                request.getEndTime()
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingService.delete(id);
    }
}

// package com.example.demo.controller;

// import com.example.demo.dto.BookingRequest;
// import com.example.demo.model.Booking;
// import com.example.demo.service.BookingService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/bookings")
// @RequiredArgsConstructor
// public class BookingController {

//     private final BookingService bookingService;

//     @PostMapping
//     public Booking create(@RequestBody BookingRequest request) {
//         return bookingService.createBooking(
//                 request.getUserId(),
//                 request.getComputerId(),
//                 request.getStartTime(),
//                 request.getEndTime()
//         );
//     }

//     @GetMapping
//     public List<Booking> getAll() {
//         return bookingService.getAll();
//     }
// }
