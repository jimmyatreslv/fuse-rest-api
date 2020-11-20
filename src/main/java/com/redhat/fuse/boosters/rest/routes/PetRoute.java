package com.redhat.fuse.boosters.rest.routes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.redhat.fuse.boosters.rest.models.Pet;

import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetRoute extends RouteBuilder {
	private Pet myPet = new Pet();
	
	@Override
	public void configure() throws Exception {		
		myPet.setName("pet 1");
		myPet.setAge(1);
		myPet.setId(1);
		
		from("direct:findPets").setBody(constant(myPet))
		.marshal().json(JsonLibrary.Jackson)
		.log(">>> ${body}");
		
		from("direct:addPet").transform(constant(myPet))
		.marshal().json(JsonLibrary.Jackson)
		.log(">>> ${body}");
	 
		from("direct:findPetById")
		  .to("bean:PetList?method=get(0)")
		  .marshal().json(JsonLibrary.Jackson)
		  .log(">>> ${body}");
	 
	}
}
