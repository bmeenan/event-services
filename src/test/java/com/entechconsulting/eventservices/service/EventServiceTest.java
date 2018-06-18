package com.entechconsulting.eventservices.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.entechconsulting.eventservices.EventTestUtils;
import com.entechconsulting.eventservices.repository.MotionEventRepository;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

	@Mock
	MotionEventRepository motionEventRepository;

	@InjectMocks
	EventService eventService;
	
	@Test
	public void saveMotionEvent_withValidData_callsRepository() {
		eventService.saveMotionEvent(EventTestUtils.testMotionEventDto());
	}
}
