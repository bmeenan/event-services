package com.entechconsulting.eventservices.dto;

public class MotionEventDTO {
	//curl --header "Content-Type: application/json" --request POST --data '{"event_occurred":"2018-15-06 14:55:02.789911","sensorId":"motion1","deviceId":"motionPi1","img":"1"}' http://10.0.0.160:8080/events/addMotion

	private String event_occurred;
	private String sensorId;
	private String deviceId;
	private String img;
	private boolean has_face;


	public String getEvent_occurred() {
		return event_occurred;
	}
	public String getSensorId() { return sensorId; }
	public String getDeviceId() { return deviceId; }
    public String getImg() { return img; }
	public boolean isHas_face() { return has_face; }

	public void setEvent_occurred(String event_occurred) { this.event_occurred = event_occurred; }
    public void setSensorId(String sensorId) { this.sensorId = sensorId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public void setImg(String img) { this.img = img; }
	public void setHas_face(boolean has_face) { this.has_face = has_face; }

}
