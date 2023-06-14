package com.hahnsoftware.codetaskbackend.interfaces;

import com.hahnsoftware.codetaskbackend.infrastructure.EventRepository;
import com.hahnsoftware.codetaskbackend.infrastructure.entities.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EventControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EventRepository repository;

    @BeforeEach
    public void cleanAndStartRepository() {
        repository.deleteAll();

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

        repository.save(event1);
        repository.save(event2);
    }

    @Test
    void testGetAllEvents() throws Exception {
        mockMvc.perform(get("/events")).andExpect(status().isOk()).andExpect(content().json("[\n" //
                + "    {\n" //
                + "        \"id\": 3,\n" //
                + "        \"title\": \"Java Conference\",\n"//
                + "        \"description\": \"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonu\",\n"
                //
                + "        \"price\": 299.99,\n" //
                + "        \"address\": {\n"//
                + "            \"street\": \"123 Street\",\n"//
                + "            \"immobileNumber\": \"1\",\n" //
                + "            \"city\": \"City 1\",\n"//
                + "            \"postalCode\": \"12345\"\n" //
                + "        },\n"//
                + "        \"capacity\": {\n" //
                + "            \"maxCapacity\": 300,\n"//
                + "            \"actualCapacity\": 45\n" //
                + "        },\n"//
                + "        \"timeInterval\": {\n"//
                + "            \"startTime\": \"2023-06-02T14:00:00\",\n"//
                + "            \"endTime\": \"2023-06-05T16:00:00\"\n" //
                + "        }\n" //
                + "    },\n"//
                + "    {\n" //
                + "        \"id\": 4,\n" //
                + "        \"title\": \"Start up Mentoring\",\n"//
                + "        \"description\": \"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt. Lorem ipsum dolor sit amet.\",\n"
                //
                + "        \"price\": 3000.0,\n" //
                + "        \"address\": {\n"//
                + "            \"street\": \"456 Street\",\n"//
                + "            \"immobileNumber\": \"290\",\n" //
                + "            \"city\": \"New York\",\n"//
                + "            \"postalCode\": \"67890\"\n" //
                + "        },\n"//
                + "        \"capacity\": {\n" //
                + "            \"maxCapacity\": 1000,\n"//
                + "            \"actualCapacity\": 999\n" //
                + "        },\n"//
                + "        \"timeInterval\": {\n"//
                + "            \"startTime\": \"2023-02-01T12:00:00\",\n"//
                + "            \"endTime\": \"2023-03-31T23:59:00\"\n" //
                + "        }\n" //
                + "    }\n" //
                + "]"));
    }

    @Test
    void testDeleteEvent() throws Exception {
        mockMvc.perform(delete("/events/1")).andExpect(status().isOk());

        Optional<EventEntity> event = repository.findById(1L);

        Assertions.assertFalse(event.isPresent());
    }

    @Test
    void testSaveEvent() throws Exception {
        AddressEntity address3 = new AddressEntity();
        address3.setStreet("11111 Street");
        address3.setImmobileNumber("901");
        address3.setCity("Santos");
        address3.setPostalCode("44300");

        TimeIntervalEntity timeInterval3 = new TimeIntervalEntity();
        timeInterval3.setStartTime(LocalDateTime.of(2023, 2, 1, 12, 0, 0));
        timeInterval3.setEndTime(LocalDateTime.of(2023, 3, 31, 23, 59, 0));

        CapacityEntity capacity3 = new CapacityEntity();
        capacity3.setMaxCapacity(1000);
        capacity3.setActualCapacity(999);

        EventEntity event3 = new EventEntity();
        event3.setTitle("Some New Event");
        event3.setPrice(5000.00);
        event3.setDescription("Lorem ipsum dolor sit amet.");
        event3.setAddress(address3);
        event3.setTimeInterval(timeInterval3);
        event3.setCapacity(capacity3);

        mockMvc.perform(put("/events").contentType(MediaType.APPLICATION_JSON).content("{\n" //
                + "    \"title\": \"Event Title\",\n" //
                + "    \"address\": {\n" //
                + "        \"street\": \"Main St\",\n" //
                + "        \"immobileNumber\": \"123\",\n" //
                + "        \"city\": \"Example City\",\n" //
                + "        \"postalCode\": \"12345\"\n" //
                + "    },\n" //
                + "    \"capacity\": {\n" //
                + "        \"maxCapacity\": 100,\n" //
                + "        \"actualCapacity\": 50\n" //
                + "    },\n" //
                + "    \"timeInterval\": {\n" //
                + "        \"startTime\": \"2023-06-01T10:00:00\",\n" //
                + "        \"endTime\": \"2023-06-01T12:00:00\"\n" //
                + "    },\n" //
                + "    \"price\": 9.99,\n" //
                + "    \"description\": \"Event description goes here\"\n" //
                + "}")).andExpect(status().isOk()).andExpect(content().json("{\n" //
                + "    \"id\": 5,\n" //
                + "    \"title\": \"Event Title\",\n" //
                + "    \"address\": {\n" //
                + "        \"street\": \"Main St\",\n" //
                + "        \"immobileNumber\": \"123\",\n" //
                + "        \"city\": \"Example City\",\n" //
                + "        \"postalCode\": \"12345\"\n" //
                + "    },\n" //
                + "    \"capacity\": {\n" //
                + "        \"maxCapacity\": 100,\n" //
                + "        \"actualCapacity\": 50\n" //
                + "    },\n" //
                + "    \"timeInterval\": {\n" //
                + "        \"startTime\": \"2023-06-01T10:00:00\",\n" //
                + "        \"endTime\": \"2023-06-01T12:00:00\"\n" //
                + "    },\n" //
                + "    \"price\": 9.99,\n" //
                + "    \"description\": \"Event description goes here\"\n" //
                + "}"));

        Optional<EventEntity> event = repository.findById(5L);

        Assertions.assertTrue(event.isPresent());
    }

    @Test
    void testSubscribeAttendantToEvent() throws Exception {
        mockMvc.perform(put("/events/subscribe").contentType(MediaType.APPLICATION_JSON).content("{\n" //
                + "        \"id\": 4,\n" //
                + "        \"title\": \"Start up Mentoring\",\n"//
                + "        \"description\": \"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt. Lorem ipsum dolor sit amet.\",\n"
                //
                + "        \"price\": 3000.0,\n" //
                + "        \"address\": {\n"//
                + "            \"street\": \"456 Street\",\n"//
                + "            \"immobileNumber\": \"290\",\n" //
                + "            \"city\": \"New York\",\n"//
                + "            \"postalCode\": \"67890\"\n" //
                + "        },\n"//
                + "        \"capacity\": {\n" //
                + "            \"maxCapacity\": 1000,\n"//
                + "            \"actualCapacity\": 999\n" //
                + "        },\n"//
                + "        \"timeInterval\": {\n"//
                + "            \"startTime\": \"2023-02-01T12:00:00\",\n"//
                + "            \"endTime\": \"2023-03-31T23:59:00\"\n" //
                + "        }\n" //
                + "    }")).andExpect(status().isOk()).andExpect(content().json("{\n" //
                + "        \"id\": 4,\n" //
                + "        \"title\": \"Start up Mentoring\",\n"//
                + "        \"description\": \"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt. Lorem ipsum dolor sit amet.\",\n"
                //
                + "        \"price\": 3000.0,\n" //
                + "        \"address\": {\n"//
                + "            \"street\": \"456 Street\",\n"//
                + "            \"immobileNumber\": \"290\",\n" //
                + "            \"city\": \"New York\",\n"//
                + "            \"postalCode\": \"67890\"\n" //
                + "        },\n"//
                + "        \"capacity\": {\n" //
                + "            \"maxCapacity\": 1000,\n"//
                + "            \"actualCapacity\": 1000\n" //
                + "        },\n"//
                + "        \"timeInterval\": {\n"//
                + "            \"startTime\": \"2023-02-01T12:00:00\",\n"//
                + "            \"endTime\": \"2023-03-31T23:59:00\"\n" //
                + "        }\n" //
                + "    }"));
    }

}
