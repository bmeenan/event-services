package com.entechconsulting.ws.eventservices;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
@Table(name="temp_event")
public class TempEvent extends Event{

  @Id
  private Integer id;
  private Integer event_id;
  private DOUBLE temp;
  private String humidity;

  //Getters
  public Integer getId(){
    return id;
  }
  public Integer getEventId(){
    return event_id;
  }
  public DOUBLE getTemp(){
    return temp;
  }
  public String getHumidity(){
    return humidity;
  }

  //Setters
  public void setId(Integer id){
    this.id = id;
  }
  public void setEventId(Integer event_id){
    this.event_id = event_id;
  }
  public void setTemp(DOUBLE temp){
    this.temp = temp;
  }
  public void setHumidity(String humidity){
    this.humidity = humidity;
  }

}
