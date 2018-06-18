package com.entechconsulting.eventservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class EventController{

  @Autowired
  private TempEventRepository tempEventRepository;
  @Autowired
  private MotionEventRepository motionEventRepository;
  @Autowired
  private EventService eventService;
  
  @GetMapping(path="/temps")
  public @ResponseBody Iterable<TempEvent> getTempEvents(){
    return tempEventRepository.findAll();
  }

  @GetMapping(path="/motions")
  public @ResponseBody Iterable<MotionEvent> getMotionEvents(){
	  return motionEventRepository.findAllEvent();
  }

  @RequestMapping(value="/addMotion", method = RequestMethod.POST)
  public ResponseEntity addMotion(@RequestBody MotionEventDTO motion) {
      System.out.println("Motion Detected " + motion);
      eventService.saveMotionEvent(motion);
      return ResponseEntity.status(HttpStatus.OK).build();
  }
}
