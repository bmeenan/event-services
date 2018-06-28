package com.entechconsulting.eventservices.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="temp_event")
public class TempEvent{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String occurred_ts;
  private String received_ts;
  private String sensor_id;
  private String temp;
  private String humidity;

  public TempEvent(){}

  public TempEvent(Integer id, String occurred_ts){
      this.id = id;
      this.occurred_ts = occurred_ts;
  }
  public TempEvent(Integer id, String temp, String humidity){
      this.id = id;
      this.temp = temp;
      this.humidity = humidity;
  }
  public TempEvent(String temp, String humidity){
    this.temp = temp;
    this.humidity = humidity;
  }
  //Getters
  public Integer getId(){
    return id;
  }
  public String getOccurredTs(){
    return occurred_ts;
  }
  public String getReceivedTs(){
    return received_ts;
  }
  public String getSensorId(){
    return sensor_id;
  }
  public String getTemp(){
    return temp;
  }
  public String getHumidity(){
    return humidity;
  }

  //Setters
  public void setId(Integer id){
    this.id = id;
  }
  public void setOccurredTs(String occurred_ts){
    this.occurred_ts = occurred_ts;
  }
  public void setReceivedTs(String received_ts){
    this.received_ts = received_ts;
  }
  public void setSensorId(String sensor_id){
    this.sensor_id = sensor_id;
  }
  public void setTemp(String temp){
    this.temp = temp;
  }
  public void setHumidity(String humidity){
    this.humidity = humidity;
  }
}
