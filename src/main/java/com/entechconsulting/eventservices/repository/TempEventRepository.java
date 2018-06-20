package com.entechconsulting.eventservices.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

public interface TempEventRepository extends CrudRepository<TempEvent,Long>{
    Iterable<TempEvent> findAll();


//    //fix query
//    @Query("select new com.entechconsulting.eventservices.repository.TempEvent(t.temp, t.humidity) from TempEvent t where t.occurred_ts < futureDate AND t.occurred_ts >  pastDate")
//    Iterable<TempEvent> getTempHumidity(@Param("pastDate") String pastDate,@Param("futureDate") String futureDate);

    //fix query
    @Query("select new com.entechconsulting.eventservices.repository.TempEvent(t.temp, t.humidity) from TempEvent t where t.occurred_ts < :futureDate AND t.occurred_ts > :pastDate")
    Iterable<TempEvent> getTempHumidity(@Param("pastDate") String pastDate,@Param("futureDate") String futureDate);

}




