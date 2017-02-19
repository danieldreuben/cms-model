package com.ros.cms.service;

import org.springframework.stereotype.Component;
import org.glassfish.jersey.server.ResourceConfig;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(TestJerseyController.class);
    }

}
