package com.entechconsulting.eventservices.service;

import java.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.entechconsulting.eventservices.dto.TempEventDTO;
import com.entechconsulting.eventservices.repository.TempEvent;
import com.entechconsulting.eventservices.repository.TempEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;

@Service
public class EventService {
	@Autowired
	private MotionEventRepository motionEventRepository;
	private TempEventRepository tempEventRepository;

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

	public void saveTempEvent(TempEventDTO dto) {
		//save motion event repository object
		TempEvent tempEvent = toTempEvent(dto);
		tempEventRepository.save(tempEvent);
	}
	private TempEvent toTempEvent(TempEventDTO dto){
		TempEvent tempEvent = new TempEvent();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
		Date date = new Date();

		tempEvent.setOccurredTs(dto.getOccurred_ts().split("\\.")[0]);
		tempEvent.setRawData(dto.toString());
		tempEvent.setSensorId(dto.getSensor_id());
		tempEvent.setReceivedTs(formatter.format(date));
		tempEvent.setTemp(dto.getTemp());
		tempEvent.setHumidity(dto.getHumidity());

		return tempEvent;
	}
}
