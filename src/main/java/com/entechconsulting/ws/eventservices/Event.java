package com.entechconsulting.ws.eventservices;
/*
import java.persistence.Entity;
import java.persistence.GeneratedValue;
import java.persistence.GenerationType;
import java.persistence.Id;
*/

public class Event{

  private Integer id;
  private String datetime;

  public Integer getId(){
    return id;
  }
  public void setId(Integer id){
    this.id = id;
  }
  public String getDateTime(){
    return datetime;
  }
  public void setDateTime(String datetime){
    this.datetime = datetime;
  }

}
