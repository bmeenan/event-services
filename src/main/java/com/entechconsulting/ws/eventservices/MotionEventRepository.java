package com.entechconsulting.ws.eventservices;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MotionEventRepository extends CrudRepository<MotionEvent,Long>{
	@Query("select new com.entechconsulting.ws.eventservices.MotionEvent(t.id, t.occurred_ts) from MotionEvent t")
	Iterable<MotionEvent> findAllEvent();
}
