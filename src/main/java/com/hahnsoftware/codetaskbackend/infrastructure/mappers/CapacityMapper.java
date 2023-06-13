package com.hahnsoftware.codetaskbackend.infrastructure.mappers;

import com.hahnsoftware.codetaskbackend.domain.Capacity;
import com.hahnsoftware.codetaskbackend.infrastructure.entities.CapacityEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CapacityMapper {

    public CapacityEntity toCapacityEntity(Capacity capacity) {
        CapacityEntity entity = new CapacityEntity();
        BeanUtils.copyProperties(capacity, entity);
        return entity;
    }

    public Capacity toCapacity(CapacityEntity entity) {
        Capacity capacity = new Capacity();
        BeanUtils.copyProperties(entity, capacity);
        return capacity;
    }
}
