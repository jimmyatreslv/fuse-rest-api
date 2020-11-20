package com.redhat.fuse.boosters.rest.routes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.redhat.fuse.boosters.rest.beans.HelloBean;

import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SayRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		from("direct:hello").to("bean:org.mycompany.models.HelloBean?method=sayHello").marshal().json(JsonLibrary.Jackson).log(">>> ${body}");
		
		from("direct:bye").bean(HelloBean.class, "say('bye message')")
		.marshal().json(JsonLibrary.Jackson)
		 
		.log(">>> ${body}");
 	}
}
