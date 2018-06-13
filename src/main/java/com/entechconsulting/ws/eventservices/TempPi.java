package com.entechconsulting.ws.eventservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
public class TempPi{

  @Id
  private Integer temp;
  private Date eventTime;

  public Integer getTemp(){
    return temp;
  }
  public void setTemp(Integer temp){
    this.temp = temp;
  }
  public Date getEventTime(){
    return eventTime;
  }
  public void setEventTime(){
    this.eventTime = eventTime;
  }

}
