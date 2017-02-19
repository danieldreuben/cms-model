package com.ros.cms;

import static org.hamcrest.Matchers.equalTo;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.boot.test.SpringApplicationConfiguration;
import com.ros.cms.Application;
//import org.springframework.boot.test.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;

//@Configuration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ComponentScan( basePackages = { "classorg.springframework.boot.test" } )
//@AutoConfigureMockMvc
//@SpringApplicationConfiguration(Application.class)

//@SpringApplicationConfiguration(classes = Application.class)
public class HelloControllerTest {

    @Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/jersey", String.class);
		assertThat(body).isEqualTo("Hello from JAX-RS");
	}

}
