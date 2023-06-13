package com.hahnsoftware.codetaskbackend.interfaces;

import com.hahnsoftware.codetaskbackend.domain.Event;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @GetMapping
    public List<Event> getAllEvents() {
        return List.of();
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {

    }

    @PutMapping
    public Event createEvent(@RequestBody @Valid Event event) {
        return null;
    }
}
