package com.entechconsulting.eventservices.service;

import java.util.ArrayList;
import java.util.List;

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

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

	@Mock
	MotionEventRepository motionEventRepository;
	
	@Mock
	TempEventRepository tempEventRepository;

	@InjectMocks
	EventService eventService;
	
	@Test
	public void saveMotionEvent_withValidData_callsRepository() {
		MotionEventDTO dto = EventTestUtils.testMotionEventDto();
		MotionEvent motion = EventTestUtils.testMotionEvent();
		
		eventService.saveMotionEvent(dto);
		
		Mockito.verify(motionEventRepository).save(motion);
	}
	
	@Test
	public void saveTempEvent_callsRepo() {
		TempEventDTO dto = EventTestUtils.testTempEventDto();
		TempEvent temp = EventTestUtils.testTempEvent();
		
		eventService.saveTempEvent(dto);
		
		Mockito.verify(tempEventRepository).save(temp);
	}
	
	@Test
	public void getImgById_callsFindImgById() {
		Integer id = 180;
		MotionEvent motionEvent = new MotionEvent();
		List<MotionEvent> list = new ArrayList<MotionEvent>();
		list.add(motionEvent);
		
		Mockito.when(motionEventRepository.findImgById(id)).thenReturn(list);
		
		eventService.getImgById(id);
		
		Mockito.verify(motionEventRepository).findImgById(id);
	}
	
	@Test
	public void getTempByDate_receivesDate_returnsTempEvent() {
		String date = "2018-06-20 12:38:00";
		TempEvent temp = new TempEvent();
		List<TempEvent> list = new ArrayList<TempEvent>();
		list.add(temp);
		
		Mockito.when(tempEventRepository.getTempHumidity(date, date)).thenReturn(list);
		
		eventService.getTempByDate(date);
		
		
	}
}
