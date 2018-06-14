package com.entechconsulting.ws.eventservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
@Table(name="event")
public class Event{

  @Id
  private Integer id;
  private String occurred_ts;
  private String received_ts;
  private String pi_type;
  private String sensor_id;
  private String raw_data;

  //Getters
  public Integer getId(){
    return id;
  }
  public String getOccuredTs(){
    return occurred_ts;
  }
  public String getReceivedTs(){
    return received_ts;
  }
  public String getPiType(){
    return pi_type;
  }
  public String getSensorId(){
    return sensor_id;
  }
  public String getRawData(){
    return raw_data;
  }

}
