package com.mail.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.mail.config.MvcConfig;
import com.mail.config.PersistanceConfig;
import com.mail.config.RootConfig;
import com.mail.config.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { RootConfig.class, MvcConfig.class, SecurityConfig.class, PersistanceConfig.class })
public class RegistrationControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void before() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testShowRegister() throws Exception {
		mockMvc.perform(get("/register.htm")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/register.jsp"));
	}

	@Test
	public void testRegister() throws Exception {
		mockMvc.perform(post("/register.htm").param("firstName", "John").param("lastName", "Doe").param("gender", "M")
				.param("dob", "11-12-1291").param("username", "john2").param("password", "123456")
				.param("rePassword", "123456").param("emailAddress", "john@xyz.com")).andDo(print())
				.andExpect(status().isOk()).andExpect(forwardedUrl("/WEB-INF/jsp/verify.jsp"));
	}

	@After
	public void after() {
		this.mockMvc = null;
	}
}
