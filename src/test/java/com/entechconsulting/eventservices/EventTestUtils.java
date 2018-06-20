package com.entechconsulting.eventservices;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.dto.TempEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.TempEvent;
import com.entechconsulting.eventservices.utilities.CompressionUtils;

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
		byte[] arr = new byte[0000]; 
		try {
			arr = CompressionUtils.compress(new byte[010011]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		motionEvent.setImg(arr);
		motionEvent.setOccurredTs(LocalDate.now().toString());
		motionEvent.setReceivedTs("19.01");
		motionEvent.setSensorId("testSensorId");
		return motionEvent;
	}
	public static TempEventDTO testTempEventDto() {
		TempEventDTO dto = new TempEventDTO();
		dto.setSensor_id("testSensorId");
		dto.setTemp("60");
		dto.setHumidity("50");
		dto.setOccurred_ts(LocalDate.now().toString());
		return dto;
	}
	public static TempEvent testTempEvent(){
		TempEvent temp = new TempEvent();
		temp.setId(1);
		temp.setHumidity("60");
		temp.setOccurredTs("Now");
		temp.setRawData("{}");
		temp.setReceivedTs("Nower");
		temp.setSensorId("temp");
		temp.setTemp("80");
		return temp;
	}
	public static MotionEvent toMotionEvent(MotionEventDTO dto){
		MotionEvent motionEvent = new MotionEvent();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getDefault());

		Date date = new Date();
		motionEvent.setOccurredTs(dto.getEvent_occurred().split("\\.")[0]);
		motionEvent.setRawData(dto.toString());
		try {
			motionEvent.setImg(CompressionUtils.compress(dto.getImg().getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		motionEvent.setSensorId(dto.getSensorId());
		motionEvent.setReceivedTs(formatter.format(date));
		return motionEvent;
	}

}
