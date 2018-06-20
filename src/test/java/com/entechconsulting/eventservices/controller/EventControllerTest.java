package com.entechconsulting.eventservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.entechconsulting.eventservices.EventTestUtils;
import com.entechconsulting.eventservices.dto.MotionEventDTO;
import com.entechconsulting.eventservices.dto.TempEventDTO;
import com.entechconsulting.eventservices.repository.MotionEvent;
import com.entechconsulting.eventservices.repository.MotionEventRepository;
import com.entechconsulting.eventservices.repository.TempEvent;
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
	public void addTemp_invokesService_andReturns200() {
		TempEventDTO dto = EventTestUtils.testTempEventDto();
		controller.addTemp(dto);
		Mockito.verify(service).saveTempEvent(dto);
	}

    @Test
    public void getImageById_invokesService_ReturnsByteArray(){
        Integer id = 181;
        MotionEvent motion = EventTestUtils.testMotionEvent();
        Mockito.when(service.getImgById(id)).thenReturn(motion);
        
        controller.getImageById(id);
        
        Mockito.verify(service).getImgById(id);
        

    }
    
    @Test
    public void getTempByDate_invokesService_ReturnsTempEvent() {
    	String date = "2018-20-06 14:40:00";
    	TempEvent temp = new TempEvent();
    	List<TempEvent> list = new ArrayList<TempEvent>();
    	list.add(temp);
    	Mockito.when(service.getTempByDate(date)).thenReturn(list);
    	
    	TempEvent actual = controller.getTempByDate(date);
    	
    	Assert.assertNotNull(actual);
    	Assert.assertEquals(temp, actual);
    	Mockito.verify(service).getTempByDate(date);
    	
    	
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