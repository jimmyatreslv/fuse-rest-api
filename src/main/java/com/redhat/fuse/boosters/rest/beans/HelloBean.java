package com.redhat.fuse.boosters.rest.beans;

import com.redhat.fuse.boosters.rest.models.ResponseType;
import org.apache.camel.BeanInject;
import org.springframework.stereotype.Component;
 
@Component
public class HelloBean {
    public ResponseType sayHello() {
        return new ResponseType("Hello, world!");
    }
    public ResponseType say(String msg) {
        return new ResponseType(msg);
    }
}