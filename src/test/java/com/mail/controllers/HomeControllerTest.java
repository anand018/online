package com.mail.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mail.config.MvcConfig;
import com.mail.config.PersistanceConfig;
import com.mail.config.RootConfig;
import com.mail.config.SecurityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { RootConfig.class, MvcConfig.class, SecurityConfig.class, PersistanceConfig.class })
public class HomeControllerTest {

	@Autowired
	private WebApplicationContext applicationContext;
	private MockMvc mockMvc;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}

	@Test
	public void testLoginGet() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/login.htm")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"));
	}
}
