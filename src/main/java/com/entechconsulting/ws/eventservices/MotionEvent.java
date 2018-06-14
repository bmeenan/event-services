package com.entechconsulting.ws.eventservices;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
@Table(name="motion_event")
public class MotionEvent extends Event{

  @Id
  private Integer id;
  private Integer event_id;
  private byte[] img;

  //Getters
  public Integer getId(){
    return id;
  }
  public Integer getEventId(){
    return event_id;
  }
  public byte[] getImg(){
    return img;
  }

  //Setters
  public void setId(Integer id){
    this.id = id;
  }
  public void setEventId(Integer event_id){
    this.event_id = event_id;
  }
  public void setImg(byte[] img){
    this.img = img;
  }

}
