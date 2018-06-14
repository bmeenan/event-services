
package com.entechconsulting.ws.eventservices;

import org.springframework.data.repository.CrudRepository;

import com.entechconsulting.ws.eventservices.Event;

public interface EventRepository extends CrudRepository<Event,Long>{
}
