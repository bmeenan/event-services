package com.entechconsulting.ws.eventservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.text.*;


@SpringBootApplication
public class EventServicesApplication {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/YYYY");
		System.out.println(ft.format(date));
		SpringApplication.run(EventServicesApplication.class, args);
	}
}
