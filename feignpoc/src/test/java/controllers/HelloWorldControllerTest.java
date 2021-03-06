package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class HelloWorldControllerTest extends AbstractTest {
	
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void getHello() throws Exception {
		String uri = "/hello";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
		
	}

}
