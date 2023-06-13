package com.hahnsoftware.codetaskbackend.infrastructure;

import com.hahnsoftware.codetaskbackend.infrastructure.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
