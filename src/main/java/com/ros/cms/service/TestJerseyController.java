package com.ros.cms.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import java.util.ArrayList;
import com.ros.cms.dto.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.ros.cms.component.CmsOrderComponent;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Path("/jersey")
public class TestJerseyController {
    @Autowired
    CmsOrderComponent cmsOrderComponent;

    @GET
    @Path("/message")
    @Produces(MediaType.TEXT_PLAIN)
    public String message() {
      return "Hello from JAX-RS ";
    }

    @GET
    @Path("/order")
    @Produces(MediaType.APPLICATION_JSON)
    public Order findOrder(@QueryParam("num") int num) {
      System.out.println("Principal: " +  SecurityContextHolder.getContext().getAuthentication().getPrincipal());
      System.out.println("Authorities.."+ SecurityContextHolder.getContext().getAuthentication().getAuthorities());
      return cmsOrderComponent.getCmsOrder(num);
    }

    @GET
    @Path("/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Order> findOrders(@DefaultValue("1") @QueryParam("from") int from,
      @DefaultValue("10") @QueryParam("to") int to) {
      return cmsOrderComponent.getCmsOrders(from, to);
    }

    @GET
    @Path("/ex")
    public Float testEx(@DefaultValue("myArgument") @QueryParam("from") String test) {
      throw new java.lang.ArithmeticException("ArithmeticEx");
    }
}
