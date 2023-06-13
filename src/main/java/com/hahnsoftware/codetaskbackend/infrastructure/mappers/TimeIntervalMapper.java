package com.hahnsoftware.codetaskbackend.infrastructure.mappers;

import com.hahnsoftware.codetaskbackend.domain.TimeInterval;
import com.hahnsoftware.codetaskbackend.infrastructure.entities.TimeIntervalEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TimeIntervalMapper {

    public TimeIntervalEntity toTimeIntervalEntity(TimeInterval timeInterval) {
        TimeIntervalEntity entity = new TimeIntervalEntity();
        BeanUtils.copyProperties(timeInterval, entity);
        return entity;
    }

    public TimeInterval toTimeInterval(TimeIntervalEntity entity) {
        TimeInterval timeInterval = new TimeInterval();
        BeanUtils.copyProperties(entity, timeInterval);
        return timeInterval;
    }
}
