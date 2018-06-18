package com.entechconsulting.eventservices;

import org.springframework.data.repository.CrudRepository;

import com.entechconsulting.eventservices.TempEvent;

public interface TempEventRepository extends CrudRepository<TempEvent,Long>{
}
