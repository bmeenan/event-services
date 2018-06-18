package com.entechconsulting.eventservices.dto;

public class TempEventDTO {
    //Localhost === curl --header "Content-Type: application/json" --request POST --data '{"occurred_ts":"2018-15-06 14:55:02.789911","sensorId":"temp1","temp":"98","humidity":"100"}' http://192.168.0.113:8080/demo/addTemp

    private String occurred_ts;
    private String sensor_id;
    private String temp;
    private String humidity;


    // Getters
    public String getOccurred_ts() {return occurred_ts;}
    public String getSensor_id() {
        return sensor_id;
    }
    public String getTemp() { return temp; }
    public String getHumidity() {
        return humidity;
    }

    //Setters
    public void setOccurred_ts(String occurred_ts){ this.occurred_ts = occurred_ts;}
    public void setSensor_id(String sensor_id) { this.sensor_id = sensor_id; }
    public void setTemp(String temp) { this.temp = temp;    }
    public void setHumidity(String humidity) { this.humidity = humidity; }

}