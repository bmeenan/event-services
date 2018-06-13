package com.entechconsulting.ws.eventservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entechconsulting.ws.eventservices.TempPi;
import com.entechconsulting.ws.eventservices.TempPiRepository;

@Controller
@RequestMapping(path="/demo")
public class MainController{
  @Autowired

  private TempPiRepository tempPiRepository;
  @GetMapping(path="/all")
  public @ResponseBody Iterable<TempPi> getAllEvents(){

    return tempPiRepository.findAll();

  }
}
