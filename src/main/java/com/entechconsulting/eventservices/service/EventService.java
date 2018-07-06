package com.entechconsulting.eventservices.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entechconsulting.eventservices.controller.EventController;
import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.dto.TempEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;
import com.entechconsulting.eventservices.repository.TempEvent;
import com.entechconsulting.eventservices.repository.TempEventRepository;
import com.entechconsulting.eventservices.utilities.CompressionUtils;

@Service
public class EventService {
	@Autowired
	private MotionEventRepository motionEventRepository;
	@Autowired
	private TempEventRepository tempEventRepository;

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EventController.class);

	// public method that changes DTO to motion event object, then calls the motion
	// event repo
	public void saveMotionEvent(MotionEventDTO dto) {
		// save motion event repository object
		MotionEvent motionEvent = toMotionEvent(dto);
		LOGGER.info("Saving motion event...");
		motionEventRepository.save(motionEvent);
		LOGGER.info("Motion Event saved");
	}

	// converts dto to motion event object
	private MotionEvent toMotionEvent(MotionEventDTO dto) {
		MotionEvent motionEvent = new MotionEvent();

		// sets appropriate date format
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getDefault());

		Date date = new Date();
		motionEvent.setOccurredTs(dto.getEvent_occurred().split("\\.")[0]);
		LOGGER.info("Compressing received image...");
		try {
			motionEvent.setImg(CompressionUtils.compress(dto.getImg().getBytes()));
		} catch (IOException e) {
			LOGGER.warn("Compression Failed");
			e.printStackTrace();
		}
		motionEvent.setSensorId(dto.getSensorId());
		motionEvent.setReceivedTs(formatter.format(date));
		return motionEvent;
	}

	// public method that changes DTO to temp event object, then calls the temp
	// event repo
	public void saveTempEvent(TempEventDTO dto) {
		// save temp event repository object
		TempEvent tempEvent = toTempEvent(dto);
		LOGGER.info("Saving Temp Event...");
		tempEventRepository.save(tempEvent);
		LOGGER.info("Temp Event saved");
	}

	// converts dto to temp event object
	private TempEvent toTempEvent(TempEventDTO dto) {
		TempEvent tempEvent = new TempEvent();

		// appropriate date settings
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getDefault());
		Date date = new Date();

		if (Objects.nonNull(dto.getOccurred_ts())) {
			tempEvent.setOccurredTs(dto.getOccurred_ts().split("\\.")[0]);
		}
		tempEvent.setSensorId(dto.getSensor_id());
		tempEvent.setTemp(dto.getTemp());
		tempEvent.setHumidity(dto.getHumidity());
		tempEvent.setReceivedTs(formatter.format(date));
		return tempEvent;
	}

	// passed id and calls the motionEventRepo
	public MotionEvent getImgById(Integer id) {
		LOGGER.info("Returning image from Database");
		return motionEventRepository.findImgById(id).iterator().next();
	}

	// gets occurred date, sets boundaries, and then calls temp event repo to get
	// teh possible temp events
	public Iterable<TempEvent> getTempByDate(String date) {
		int milliseconds_for_change = 900000;

		// do date formatting here
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getDefault());

		Date pastDate;
		Date futureDate;
		try {
			pastDate = new Date(formatter.parse(date).getTime() - milliseconds_for_change);
			futureDate = new Date(formatter.parse(date).getTime() + milliseconds_for_change);

			LOGGER.info(
					"Returning Temp events from " + formatter.format(pastDate) + " to " + formatter.format(futureDate));
			return tempEventRepository.getTempHumidity(formatter.format(pastDate), formatter.format(futureDate));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

//adding comment

}