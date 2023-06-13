package com.hahnsoftware.codetaskbackend.interfaces;

import com.hahnsoftware.codetaskbackend.domain.Event;
import com.hahnsoftware.codetaskbackend.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @PutMapping
    public Event saveEvent(@RequestBody @Valid Event event) {
        return eventService.saveEvent(event);
    }
}
