package com.example.demo.controller;

import com.example.demo.model.Computer;
import com.example.demo.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computers")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerRepository computerRepository;

    // GET all
    @GetMapping
    public List<Computer> getAll() {
        return computerRepository.findAll();
    }

    // GET by id (необязательно, но полезно)
    @GetMapping("/{id}")
    public Computer getById(@PathVariable Long id) {
        return computerRepository.findById(id).orElseThrow();
    }

    // POST
    @PostMapping
    public Computer create(@RequestBody Computer computer) {
        return computerRepository.save(computer);
    }

    // PUT
    @PutMapping("/{id}")
    public Computer update(@PathVariable Long id,
                           @RequestBody Computer updatedComputer) {

        Computer computer = computerRepository.findById(id).orElseThrow();

        computer.setName(updatedComputer.getName());
        computer.setDescription(updatedComputer.getDescription());
        computer.setActive(updatedComputer.isActive());

        return computerRepository.save(computer);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        computerRepository.deleteById(id);
    }
}


// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.Computer;
// import com.example.demo.repository.ComputerRepository;

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/api/computers")
// @RequiredArgsConstructor
// public class ComputerController {

//     private final ComputerRepository computerRepository;

//     @GetMapping
//     public List<Computer> getAll() {
//         return computerRepository.findAll();
//     }

//     @PostMapping
//     public Computer create(@RequestBody Computer computer) {
//         return computerRepository.save(computer);
//     }
// }