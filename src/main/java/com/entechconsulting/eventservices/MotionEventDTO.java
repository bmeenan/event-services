package com.entechconsulting.eventservices;

public class MotionEventDTO {
	//curl --header "Content-Type: application/json" --request POST --data '{"event_occurred":"2018-15-06 14:55:02.789911","sensorId":"motion1","deviceId":"motionPi1","img":"1"}' http://34.239.113.101:8080/demo/addMotion

	private String event_occurred;
	private String sensorId;
	private String deviceId;
	private String img;

	public String getEvent_occurred() {
		return event_occurred;
	}
	public void setEvent_occurred(String event_occurred) {
		this.event_occurred = event_occurred;
	}
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


}
