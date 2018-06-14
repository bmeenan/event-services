package com.entechconsulting.ws.eventservices;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
	private MotionEventRepository motionEventRepository;
	public void saveMotionEvent(MotionEventDTO dto) {
		//save motion event repository object
		MotionEvent motionEvent = toMotionEvent(dto);
		motionEventRepository.save(motionEvent);
	}
	private MotionEvent toMotionEvent(MotionEventDTO dto) {
		MotionEvent motionEvent = new MotionEvent();
		motionEvent.setOccurredTs(dto.getEvent_occurred());
		motionEvent.setRawData(dto.toString());
		motionEvent.setImg(dto.getImg().getBytes());
		motionEvent.setSensorId(dto.getSensorId());
		motionEvent.setReceivedTs(LocalDate.now().toString());
		
		return motionEvent;
	}
}
