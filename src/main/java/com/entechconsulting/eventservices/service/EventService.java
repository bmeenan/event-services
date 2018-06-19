package com.entechconsulting.eventservices.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;
import com.entechconsulting.eventservices.utilities.CompressionUtils;

@Service
public class EventService {
	@Autowired
	private MotionEventRepository motionEventRepository;

	public void saveMotionEvent(MotionEventDTO dto){
		//save motion event repository object
		MotionEvent motionEvent = toMotionEvent(dto);
		motionEventRepository.save(motionEvent);
	}
	private MotionEvent toMotionEvent(MotionEventDTO dto){
		MotionEvent motionEvent = new MotionEvent();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
	public MotionEvent getImgById(Integer id) {
		return motionEventRepository.findImgById(id).iterator().next();
	}
}
