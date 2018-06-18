package com.entechconsulting.eventservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MotionEventRepository extends CrudRepository<MotionEvent,Long>{
	@Query("select new com.entechconsulting.eventservices.repository.MotionEvent(t.id, t.occurred_ts) from MotionEvent t order by t.occurred_ts desc")
	Iterable<MotionEvent> findAllEvent();
}
