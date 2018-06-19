package com.entechconsulting.eventservices.controller;

import com.entechconsulting.eventservices.dto.TempEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;
import com.entechconsulting.eventservices.repository.TempEvent;
import com.entechconsulting.eventservices.repository.TempEventRepository;
import com.entechconsulting.eventservices.service.EventService;

@Controller
@RequestMapping(path="/demo")
public class EventController {

    @Autowired
    private TempEventRepository tempEventRepository;
    @Autowired
    private MotionEventRepository motionEventRepository;
    @Autowired
    private EventService eventService;

    @GetMapping(path = "/temps")
    public @ResponseBody
    Iterable<TempEvent> getTempEvents() {
        return tempEventRepository.findAll();
    }

    @GetMapping(path = "/motions")
    public @ResponseBody
    Iterable<MotionEvent> getMotionEvents() {
        return motionEventRepository.findAllEvent();
    }

    @RequestMapping(value = "/addMotion", method = RequestMethod.POST)
    public ResponseEntity addMotion(@RequestBody MotionEventDTO motion) {
        System.out.println("Motion Detected " + motion);
        eventService.saveMotionEvent(motion);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/addTemp", method = RequestMethod.POST)
    public ResponseEntity addTemp(@RequestBody TempEventDTO temp) {
        System.out.println("Temp Detected " + temp);
        eventService.saveTempEvent(temp);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/getImageById/{id}")
    public @ResponseBody
    byte[] getImageById(@PathVariable Integer id) {
        return eventService.getImgById(id).getImg();
    }
}

