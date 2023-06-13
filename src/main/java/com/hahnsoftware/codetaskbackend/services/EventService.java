package com.hahnsoftware.codetaskbackend.services;

import com.hahnsoftware.codetaskbackend.domain.Event;
import com.hahnsoftware.codetaskbackend.infrastructure.EventRepository;
import com.hahnsoftware.codetaskbackend.infrastructure.entities.EventEntity;
import com.hahnsoftware.codetaskbackend.infrastructure.mappers.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    public List<Event> getAllEvents() {
        List<EventEntity> eventEntityList = eventRepository.findAll();
        return eventEntityList.stream()
                .map(eventEntity -> eventMapper.toDomain(eventEntity))
                .collect(Collectors.toList());
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event saveEvent(Event event) {
        EventEntity savedEventEntity = eventRepository.save(eventMapper.toEntity(event));
        return eventMapper.toDomain(savedEventEntity);
    }
}
