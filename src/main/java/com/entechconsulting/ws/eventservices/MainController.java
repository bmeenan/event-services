package com.entechconsulting.ws.eventservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entechconsulting.ws.eventservices.Event;
import com.entechconsulting.ws.eventservices.EventRepository;

@Controller
@RequestMapping(path="/demo")
public class MainController{
  @Autowired

  private EventRepository eventRepository;
  @GetMapping(path="/all")
  public @ResponseBody Iterable<Event> getAllEvents(){
    return eventRepository.findAll();
  }
}
