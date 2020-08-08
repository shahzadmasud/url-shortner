package com.hackerrank.github.manager.impl;

import com.hackerrank.github.dto.EventDTO;
import com.hackerrank.github.model.Event;

import java.util.List;

public interface EventManager {


    List<Event> getEventsByActorId(Long actorId);

    String save(EventDTO event) throws Exception;

    List<EventDTO> findAll();

    void deleteAll();
}
