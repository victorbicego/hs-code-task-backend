package com.hahnsoftware.codetaskbackend.infrastructure.mappers;

import com.hahnsoftware.codetaskbackend.domain.Event;
import com.hahnsoftware.codetaskbackend.infrastructure.entities.EventEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Autowired
    private CapacityMapper capacityMapper;

    public EventEntity toEntity(Event event) {
        EventEntity entity = new EventEntity();
        BeanUtils.copyProperties(event, entity);
        entity.setAddress(addressMapper.toAddressEntity(event.getAddress()));
        entity.setCapacity(capacityMapper.toCapacityEntity(event.getCapacity()));
        entity.setTimeInterval(timeIntervalMapper.toTimeIntervalEntity(event.getTimeInterval()));
        return entity;
    }

    public Event toDomain(EventEntity entity) {
        Event event = new Event();
        BeanUtils.copyProperties(entity, event);
        event.setAddress(addressMapper.toAddress(entity.getAddress()));
        event.setCapacity(capacityMapper.toCapacity(entity.getCapacity()));
        event.setTimeInterval(timeIntervalMapper.toTimeInterval(entity.getTimeInterval()));
        return event;
    }

}
