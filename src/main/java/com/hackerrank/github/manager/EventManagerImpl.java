package com.hackerrank.github.manager;

import com.hackerrank.github.dto.ActorDTO;
import com.hackerrank.github.dto.EventDTO;
import com.hackerrank.github.dto.RepoDTO;
import com.hackerrank.github.manager.impl.EventManager;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.EventService;

import com.hackerrank.github.util.TxtWriter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EventManagerImpl implements EventManager {



    @Value("${folder.path}")
    private String folderPath;

    @Autowired
    private EventService eventService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Event> getEventsByActorId(Long actorId) {
        return null;
    }

    @Override
    public String save(EventDTO event) throws Exception {
        Date date= new Date();
        RepoDTO repo = event.getRepo();
        ActorDTO actor= event.getActor();


        String fileName= folderPath+ Calendar.getInstance().getTimeInMillis() + "Url";
        System.out.println(new Date().getTime());
        System.out.println(Calendar.getInstance().getTimeInMillis());

        TxtWriter.createUrlFile(fileName,repo.getUrl());
        repo.setUrl(fileName);

        String fileName2= folderPath+ Calendar.getInstance().getTimeInMillis() + "Url";
        System.out.println(new Date().getTime());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        TxtWriter.createUrlFile(fileName2,actor.getAvatar());
        actor.setAvatar( fileName2);


        event.setRepo(repo);
        event.setActor(actor);


        eventService.save(mapper.map(event,Event.class));
        return "Saved successfully";
    }

    @Override
    public List<EventDTO> findAll() {

        Iterable<Event> iterable=eventService.findAll();
        List<EventDTO> events = new ArrayList<>();
        iterable.forEach(event -> events.add(mapper.map(event, EventDTO.class)));

        return events;
    }

    @Override
    public void deleteAll() {

    }
}
