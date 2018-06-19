package com.entechconsulting.eventservices.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.entechconsulting.eventservices.EventTestUtils;
import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.repository.TempEventRepository;
import com.entechconsulting.eventservices.service.EventService;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {
	
	@Mock
	EventService service;
	@Mock
	TempEventRepository tempEventRepository;
	@InjectMocks
	EventController controller;
	
	@Test
	public void addMotion_invokesService_andReturns200() {
		MotionEventDTO dto = EventTestUtils.testMotionEventDto();
		controller.addMotion(dto);
		Mockito.verify(service).saveMotionEvent(dto);
	}
	
	@Test
	public void getTempEvents_invokesTempRepo_andReturnsIterable() {
		controller.getTempEvents();
		Mockito.verify(tempEventRepository).findAll();
	}

}