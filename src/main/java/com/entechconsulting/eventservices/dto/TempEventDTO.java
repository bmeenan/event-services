package com.entechconsulting.eventservices.dto;

public class TempEventDTO {
    //curl --header "Content-Type: application/json" --request POST --data '{"occurred_ts":"2018-15-06 14:55:02.789911","received_ts":"2018-15-06 14:55:03.000000","sensorId":"temp1","deviceId":"tempPi1","temp":"98"}' http://34.239.113.101:8080/demo/addTemp

    private String occurred_ts;
    private String received_ts;
    private String sensor_id;
    private String device_id;
    private double temp;
    private double humidity;


    // Getters
    public String getOccurred_ts() {return occurred_ts;}
    public String getReceived_ts() {
        return received_ts;
    }
    public String getSensor_id() {
        return sensor_id;
    }
    public String getDevice_id() {
        return device_id;
    }
    public double getTemp() { return temp; }
    public double getHumidity() {
        return humidity;
    }

    //Setters
    public void setReceived_ts(String received_ts) {
        this.received_ts = received_ts;
    }
    public void setSensor_id(String sensor_id) { this.sensor_id = sensor_id; }
    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    public void setOccurred_ts(String occurred_ts){ this.occurred_ts = occurred_ts; }
}