package com.ros.cms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.io.IOException;

import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.*;

import com.ros.cms.dto.Order;
import com.ros.cms.service.TestJerseyController;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableAutoConfiguration
@JsonTest
public class OrderServiceTest {
 
    @MockBean
    private TestJerseyController orderService;
 
    @Autowired
    private JacksonTester<Order> json;
    
    @Test
    public void testFindOrderServiceEndpoint() throws IOException {
    	System.out.println("=> checking order service..");
        //Mockito.when(this.orderService.findOrder(123)).thenReturn(new Order("123"));
    	given(this.orderService.findOrder(123)).willReturn(new Order("123"));
    	Order order = orderService.findOrder(123);
    	assertEquals("order#: 123", order.toString());
        
        // test the JSON
    	//System.out.println("->" + order);
    	//System.out.println("->" + this.json.write(order).toString());
    	//assertThat(this.json.write(order)).isEqualToJson("expected.json");
    	
        //assertThat(this.json.write(order)).hasJsonPathStringValue("@.make");

        // Or use JSON path based assertions
        //assertThat(this.json.write(details)).hasJsonPathStringValue("@.make");
    }
   
}