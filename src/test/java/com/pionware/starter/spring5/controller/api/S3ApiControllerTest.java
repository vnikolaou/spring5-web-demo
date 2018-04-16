package com.pionware.starter.spring5.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pionware.starter.spring5.controller.api.S3ApiController;

public class S3ApiControllerTest {
	private MockMvc mockMvc; 
	@Before 
	public void setup() { 
		this.mockMvc = MockMvcBuilders.standaloneSetup( 
				new S3ApiController()) 
				.build(); 
	} 

	@Test 
	public void testWelcomeApi() throws Exception { 
		this.mockMvc.perform(get("/welcome") 
				.accept(MediaType.parseMediaType 
						("application/html;charset=UTF-8"))) 
		.andExpect(status().isOk()) 
		.andExpect( content().contentType 
				("application/html;charset=UTF-8")) 
		.andExpect(content(). 
				string("Welcome Vag")); 
	}    
}
