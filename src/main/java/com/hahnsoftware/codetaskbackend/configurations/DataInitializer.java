package com.hahnsoftware.codetaskbackend.configurations;

import com.hahnsoftware.codetaskbackend.infrastructure.EventRepository;
import com.hahnsoftware.codetaskbackend.infrastructure.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer {

    @Autowired
    private EventRepository eventRepository;

    public void initializeData() {
        AddressEntity address1 = new AddressEntity();
        address1.setStreet("123 Street");
        address1.setImmobileNumber("1");
        address1.setCity("City 1");
        address1.setPostalCode("12345");

        AddressEntity address2 = new AddressEntity();
        address2.setStreet("456 Street");
        address2.setImmobileNumber("290");
        address2.setCity("New York");
        address2.setPostalCode("67890");

        TimeIntervalEntity timeInterval1 = new TimeIntervalEntity();
        timeInterval1.setStartTime(LocalDateTime.of(2023, 6, 2, 14, 0, 0));
        timeInterval1.setEndTime(LocalDateTime.of(2023, 6, 5, 16, 0, 0));

        TimeIntervalEntity timeInterval2 = new TimeIntervalEntity();
        timeInterval2.setStartTime(LocalDateTime.of(2023, 2, 1, 12, 0, 0));
        timeInterval2.setEndTime(LocalDateTime.of(2023, 3, 31, 23, 59, 0));

        CapacityEntity capacity1 = new CapacityEntity();
        capacity1.setMaxCapacity(300);
        capacity1.setActualCapacity(45);

        CapacityEntity capacity2 = new CapacityEntity();
        capacity2.setMaxCapacity(1000);
        capacity2.setActualCapacity(999);

        EventEntity event1 = new EventEntity();
        event1.setTitle("Java Conference");
        event1.setPrice(299.99);
        event1.setDescription("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonu");
        event1.setAddress(address1);
        event1.setTimeInterval(timeInterval1);
        event1.setCapacity(capacity1);

        EventEntity event2 = new EventEntity();
        event2.setTitle("Start up Mentoring");
        event2.setPrice(3000.00);
        event2.setDescription(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt. Lorem ipsum dolor sit amet.");
        event2.setAddress(address2);
        event2.setTimeInterval(timeInterval2);
        event2.setCapacity(capacity2);

        eventRepository.save(event1);
        eventRepository.save(event2);
    }
}
