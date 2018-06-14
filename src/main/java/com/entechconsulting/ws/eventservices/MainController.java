package com.entechconsulting.ws.eventservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entechconsulting.ws.eventservices.TempEvent;
import com.entechconsulting.ws.eventservices.MotionEvent;
import com.entechconsulting.ws.eventservices.TempEventRepository;
import com.entechconsulting.ws.eventservices.MotionEventRepository;

@Controller
@RequestMapping(path="/demo")
public class MainController{
  @Autowired
  private TempEventRepository tempEventRepository;
  @Autowired
  private MotionEventRepository motionEventRepository;

  @GetMapping(path="/temps")
  public @ResponseBody Iterable<TempEvent> getTempEvents(){
    return tempEventRepository.findAll();
  }

  @GetMapping(path="/motions")
  public @ResponseBody Iterable<MotionEvent> getMotionEvents(){
    return motionEventRepository.findAll();
  }
}
