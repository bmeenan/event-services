package com.entechconsulting.eventservices.controller;

import java.io.IOException;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.dto.TempEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;
import com.entechconsulting.eventservices.repository.TempEvent;
import com.entechconsulting.eventservices.repository.TempEventRepository;
import com.entechconsulting.eventservices.service.EventService;
import com.entechconsulting.eventservices.utilities.CompressionUtils;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/demo")
public class EventController{

    @Autowired
    private TempEventRepository tempEventRepository;
    @Autowired
    private MotionEventRepository motionEventRepository;
    @Autowired
    private EventService eventService;

    //returns all rows and columns in the temp_events table
    @GetMapping(path="/temps")
    public @ResponseBody Iterable<TempEvent> getTempEvents(){
        return tempEventRepository.findAll();
    }

    //returns all rows in the motion_event table (just id and occurred_ts columns)
    @GetMapping(path="/motions")
    public @ResponseBody Iterable<MotionEvent> getMotionEvents(){
      return motionEventRepository.findAllEvent();
    }

    //uses POST to save a motion event to the db
    @RequestMapping(value="/addMotion", method = RequestMethod.POST)
    public ResponseEntity<Void> addMotion(@RequestBody MotionEventDTO motion){
        //log for the system
        System.out.println("Motion Detected " + motion);
        //calls the event service method
        eventService.saveMotionEvent(motion);
        //returns the response status to the pi
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //uses POST to save a temp event to the db
    @RequestMapping(value = "/addTemp", method = RequestMethod.POST)
    public ResponseEntity<Void> addTemp(@RequestBody TempEventDTO temp) {
        //log for the system
        System.out.println("Temp Detected " + temp);
        //calls the event service method
        eventService.saveTempEvent(temp);
        //returns the response status to the pi
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //uses GET to retrieve an image from the db by its id
    @GetMapping(path="/getImageById/{id}")
    public @ResponseBody byte[] getImageById(@PathVariable Integer id){
        try {
            //decompresses the image before sending it to the angular project
            return CompressionUtils.decompress(eventService.getImgById(id).getImg());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //uses GET to retrieve a temp event by closest date and time
    @GetMapping(path="/getTempByDate/{date}")
    public @ResponseBody TempEvent getTempByDate(@PathVariable String date){

      if(eventService.getTempByDate(date).iterator().hasNext()){
        return eventService.getTempByDate(date).iterator().next();
      }
      
      String temp = null;
      String hum = null;
      return (new TempEvent(temp,hum));

    }
}