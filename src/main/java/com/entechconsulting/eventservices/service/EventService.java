package com.entechconsulting.eventservices.service;

import java.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;

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

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		Date date = new Date();

		motionEvent.setOccurredTs(dto.getEvent_occurred().split("\\.")[0]);
		motionEvent.setRawData(dto.toString());
		motionEvent.setImg(dto.getImg().getBytes());
		motionEvent.setSensorId(dto.getSensorId());
		motionEvent.setReceivedTs(formatter.format(date));

		return motionEvent;
	}
	public MotionEvent getImgById(Integer id) {
		return motionEventRepository.findImgById(id).iterator().next();
	}
}
