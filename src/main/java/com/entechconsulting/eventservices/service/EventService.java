package com.entechconsulting.eventservices.service;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.dto.TempEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;
import com.entechconsulting.eventservices.repository.TempEvent;
import com.entechconsulting.eventservices.repository.TempEventRepository;
import com.entechconsulting.eventservices.utilities.CompressionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


@Service
public class EventService {
	@Autowired
	private MotionEventRepository motionEventRepository;
	@Autowired
	private TempEventRepository tempEventRepository;

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

	public void saveTempEvent(TempEventDTO dto) {
		//save temp event repository object
		TempEvent tempEvent = toTempEvent(dto);
		tempEventRepository.save(tempEvent);
	}

	private TempEvent toTempEvent(TempEventDTO dto) {
		TempEvent tempEvent = new TempEvent();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		if (Objects.nonNull(dto.getOccurred_ts())) {
			tempEvent.setOccurredTs(dto.getOccurred_ts().split("\\.")[0]);
		}
		tempEvent.setRawData(dto.toString());
		tempEvent.setSensorId(dto.getSensor_id());
		tempEvent.setTemp(dto.getTemp());
		tempEvent.setHumidity(dto.getHumidity());
		tempEvent.setReceivedTs(formatter.format(date));
		return tempEvent;}

	public MotionEvent getImgById(Integer id){
		return motionEventRepository.findImgById(id).iterator().next();
	}

	public TempEvent getTempByDate(String date){

		//do formating here


		return tempEventRepository.getTempHumidity(upperDate, lowerDate);
	}

}