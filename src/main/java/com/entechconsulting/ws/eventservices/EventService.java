package com.entechconsulting.ws.eventservices;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
	private MotionEventRepository motionEventRepository;

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	Date date = new Date();

	public void saveMotionEvent(MotionEventDTO dto) {
		//save motion event repository object
		MotionEvent motionEvent = toMotionEvent(dto);
		motionEventRepository.save(motionEvent);
	}
	private MotionEvent toMotionEvent(MotionEventDTO dto) {
		MotionEvent motionEvent = new MotionEvent();
		motionEvent.setOccurredTs(dto.getEvent_occurred().split("\\.")[0]);
		motionEvent.setRawData(dto.toString());
		motionEvent.setImg(dto.getImg().getBytes());
		motionEvent.setSensorId(dto.getSensorId());
		motionEvent.setReceivedTs(formatter.format(date).toString());

		return motionEvent;
	}
	public MotionEvent getImgById(Integer id) {
		return motionEventRepository.findImgById(id).iterator().next();
	}
	
}
