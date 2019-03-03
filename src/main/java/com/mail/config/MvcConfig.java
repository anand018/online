package com.mail.config;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@ComponentScan("com.mail.controllers")
public class MvcConfig extends WebMvcConfigurerAdapter {
	private static final Logger logger = Logger.getLogger(MvcConfig.class);

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		try {
			registry.addViewController("login.htm").setViewName("login");

		} catch (Exception e) {
			if (logger.isDebugEnabled())
				logger.debug(e.getMessage());
		}

	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	@Override
	public Validator getValidator() {
		return super.getValidator();
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = null;
		messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("error");
		return messageSource;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multiPartResolver = new CommonsMultipartResolver();
		multiPartResolver.setMaxUploadSize(50971520); // 50 MB
		multiPartResolver.setMaxInMemorySize(5048576); // 50 MB
		return multiPartResolver;
	}
}
