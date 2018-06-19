package com.entechconsulting.eventservices;

import java.time.LocalDate;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;

public class EventTestUtils {

	public static MotionEventDTO testMotionEventDto() {
		MotionEventDTO dto = new MotionEventDTO();
		dto.setDeviceId("testDeviceId");
		dto.setEvent_occurred(LocalDate.now().toString());
		dto.setImg("testImageData");
		dto.setSensorId("testSensorId");
		return dto;
	}
	public static MotionEvent testMotionEvent(){
		MotionEvent motionEvent = new MotionEvent();
		motionEvent.setId(1);
		motionEvent.setImg(new byte[] {000});
		motionEvent.setOccurredTs("19:00");
		motionEvent.setReceivedTs("19.01");
		motionEvent.setSensorId("motion1");
		return motionEvent;
	}

}
