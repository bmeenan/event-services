package com.entechconsulting.eventservices.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.entechconsulting.eventservices.EventTestUtils;
import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.service.EventService;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {
	
	@Mock
	EventService service;
	@InjectMocks
	EventController controller;
	
	@Test
	public void addMotion_invokesService_andReturns200() {
		MotionEventDTO dto = EventTestUtils.testMotionEventDto();
		controller.addMotion(dto);
		Mockito.verify(service).saveMotionEvent(dto);
	}
}