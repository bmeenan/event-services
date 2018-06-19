package com.entechconsulting.eventservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MotionEventRepository extends CrudRepository<MotionEvent,Long>{
	@Query("select new com.entechconsulting.eventservices.repository.MotionEvent(t.id, t.occurred_ts) from MotionEvent t order by t.occurred_ts desc")
	Iterable<MotionEvent> findAllEvent();

	@Query("select new com.entechconsulting.eventservices.repository.MotionEvent(t.img) from MotionEvent t where t.id = :id")
	Iterable<MotionEvent> findImgById(@Param("id") Integer id);
}
