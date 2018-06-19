package com.entechconsulting.eventservices;

import java.time.LocalDate;

import com.entechconsulting.eventservices.dto.MotionEventDTO;

public class EventTestUtils {

	public static MotionEventDTO testMotionEventDto() {
		MotionEventDTO dto = new MotionEventDTO();
		dto.setDeviceId("testDeviceId");
		dto.setEvent_occurred(LocalDate.now().toString());
		dto.setImg("testImageData");
		dto.setSensorId("testSensorId");
		return dto;
	}

}
