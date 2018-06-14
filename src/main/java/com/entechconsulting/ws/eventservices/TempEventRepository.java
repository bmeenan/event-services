package com.entechconsulting.ws.eventservices;

import org.springframework.data.repository.CrudRepository;
import com.entechconsulting.ws.eventservices.TempEvent;

public interface TempEventRepository extends CrudRepository<TempEvent,Long>{
}
