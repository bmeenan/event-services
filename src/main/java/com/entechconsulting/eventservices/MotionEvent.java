package com.entechconsulting.eventservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="motion_event")
public class MotionEvent{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String occurred_ts;
  private String received_ts;
  private String sensor_id;
  private String raw_data;
  private byte[] img;
  
  public MotionEvent() {
	  
  }
  
  public MotionEvent(Integer id,String occurred_ts) {
	  this.id = id;
	  this.occurred_ts = occurred_ts;
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
  public String getRawData(){
    return raw_data;
  }
  public byte[] getImg(){
    return img;
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
  public void setRawData(String raw_data){
    this.raw_data = raw_data;
  }
  public void setImg(byte[] img){
    this.img = img;
  }

}
