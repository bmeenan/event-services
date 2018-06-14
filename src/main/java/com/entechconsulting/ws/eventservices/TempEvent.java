package com.entechconsulting.ws.eventservices;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="temp_event")
public class TempEvent{

  @Id
  private Integer id;
  private String occurred_ts;
  private String received_ts;
  private String sensor_id;
  private String raw_data;
  private double temp;
  private String humidity;

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
  public String getSensorId(){
    return sensor_id;
  }
  public String getRawData(){
    return raw_data;
  }
  public double getTemp(){
    return temp;
  }
  public String getHumidity(){
    return humidity;
  }

  //Setters
  public void setId(Integer id){
    this.id = id;
  }
  public void setOccuredTs(String occurred_ts){
    this.occurred_ts = occurred_ts;
  }
  public void setReceivedTs(String received_ts){
    this.received_ts = received_ts;
  }
  public void setSensorId(String sensor_id){
    this.sensor_id = sensor_id;
  }
  public void setRawData(String raw_data){
    this.raw_data = raw_data;
  }
  public void setTemp(double temp){
    this.temp = temp;
  }
  public void setHumidity(String humidity){
    this.humidity = humidity;
  }
}
