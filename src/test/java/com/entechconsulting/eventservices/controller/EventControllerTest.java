package com.entechconsulting.eventservices.controller;

import com.entechconsulting.eventservices.repository.MotionEvent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.entechconsulting.eventservices.EventTestUtils;
import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.repository.MotionEventRepository;
import com.entechconsulting.eventservices.repository.TempEventRepository;
import com.entechconsulting.eventservices.service.EventService;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {
	
	@Mock
	EventService service;
	@Mock
	TempEventRepository tempEventRepository;
	@Mock
	MotionEventRepository motionEventRepository;
	@InjectMocks
	EventController controller;
	
	@Test
	public void addMotion_invokesService_andReturns200() {
		MotionEventDTO dto = EventTestUtils.testMotionEventDto();
		controller.addMotion(dto);
		Mockito.verify(service).saveMotionEvent(dto);
	}

    @Test
    public void getImageById_invokesService_ReturnsByteArray(){
        Integer id = 181;
        MotionEvent motionEvent = EventTestUtils.testMotionEvent();
        Mockito.when(service.getImgById(id)).thenReturn(motionEvent);
        controller.getImageById(id);
        //Mockito.verify(motionEvent).getImg();

    }
	
	@Test
	public void getTempEvents_invokesTempRepo_andReturnsIterable() {
		controller.getTempEvents();
		Mockito.verify(tempEventRepository).findAll();

	}
	
	@Test 
	public void getMotionEvents_invokesMotionRepo_andReturnsIterable() {
		controller.getMotionEvents();
		Mockito.verify(motionEventRepository).findAllEvent();
	}




}