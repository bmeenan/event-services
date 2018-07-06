package com.entechconsulting.eventservices.controller;

import java.io.IOException;
import java.util.zip.DataFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.dto.TempEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;
import com.entechconsulting.eventservices.repository.TempEvent;
import com.entechconsulting.eventservices.repository.TempEventRepository;
import com.entechconsulting.eventservices.service.EventService;
import com.entechconsulting.eventservices.utilities.CompressionUtils;

/**
 * The controller class is the main entry point to event services. Here, all
 * endpoints are defined. Should the project grow, we may eventually decide to
 * create additional controller classes
 */
@Controller
@CrossOrigin(origins = "*")
public class EventController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

	@Autowired
	private TempEventRepository tempEventRepository;
	@Autowired
	private MotionEventRepository motionEventRepository;
	@Autowired
	private EventService eventService;

	// returns all rows and columns in the temp_events table
	@RequestMapping(value = "/events/temps", method = RequestMethod.GET)
	public @ResponseBody Iterable<TempEvent> getTempEvents() {
		LOGGER.info("Returning all temperature data...");
		return tempEventRepository.findAll();
	}

	// returns all rows in the motion_event table (just id and occurred_ts columns)
	@RequestMapping(value = "/events/motions", method = RequestMethod.GET)
	public @ResponseBody Iterable<MotionEvent> getMotionEvents() {
		LOGGER.info("Returning all motion event data...");
		return motionEventRepository.findAllEvent();
	}

	// uses POST to save a motion event to the db
	@RequestMapping(value = "/events/addMotion", method = RequestMethod.POST)
	public ResponseEntity<Void> addMotion(@RequestBody MotionEventDTO motion) {
		// log for the system
		LOGGER.info("Motion Detected: " + motion);
		// calls the event service method
		LOGGER.info("Calling Event Service 'saveMotionEvent(motion)' method...");
		eventService.saveMotionEvent(motion);
		// returns the response status to the pi
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// uses POST to save a temp event to the db
	@RequestMapping(value = "/events/addTemp", method = RequestMethod.POST)
	public ResponseEntity<Void> addTemp(@RequestBody TempEventDTO temp) {
		// log for the system
		LOGGER.info("Temp Detected: " + temp);
		// calls the event service method
		LOGGER.info("Calling Event Service 'saveTempEvent(temp)' method...");
		eventService.saveTempEvent(temp);
		// returns the response status to the pi
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	// uses GET to retrieve an image from the db by its id
	@RequestMapping(value = "/events/getImageById/{id}", method = RequestMethod.GET)
	public @ResponseBody byte[] getImageById(@PathVariable Integer id) {
		LOGGER.info("Decompressing image...");
		try {
			// decompresses the image before sending it to the angular project
			return CompressionUtils.decompress(eventService.getImgById(id).getImg());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DataFormatException e) {
			e.printStackTrace();
		}
		LOGGER.warn("Decompression failed");
		return null;
	}

	// uses GET to retrieve a temp event by closest date and time
	@RequestMapping(value = "/events/getTempByDate/{date}", method = RequestMethod.GET)
	public @ResponseBody TempEvent getTempByDate(@PathVariable String date) {
		LOGGER.info("Calling Event Service 'getTempByDate(date)' method...");
		if (eventService.getTempByDate(date).iterator().hasNext()) {
			LOGGER.info("Dates found");
			return eventService.getTempByDate(date).iterator().next();
		}
		LOGGER.info("No dates found");
		String temp = null;
		String hum = null;
		return (new TempEvent(temp, hum));
	}
}