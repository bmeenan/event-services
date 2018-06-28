package com.entechconsulting.eventservices.repository;

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
  private byte[] img;

  public MotionEvent() {

  }
  public MotionEvent(Integer id) {
    this.id = id;
  }
  public MotionEvent(Integer id, byte[] img) {
	  this.id = id;
	  this.img = img;
  }
  public MotionEvent(byte[] img) {
	  this.img = img;
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
  public void setImg(byte[] img){
    this.img = img;
  }

}
