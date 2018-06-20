package com.entechconsulting.eventservices.repository;

import org.springframework.data.repository.CrudRepository;

import com.entechconsulting.eventservices.repository.TempEvent;

public interface TempEventRepository extends CrudRepository<TempEvent,Long>{
    Iterable<TempEvent> findAll();


    //fix query
    @Query("select new com.entechconsulting.eventservices.repository.TempEvent(t.temp, t.humidity) from TempEvent t where t.id = :id")
    Iterable<TempEvent> getTempHumidity(@Param("date") Integer id);

}



getTempHumidity
