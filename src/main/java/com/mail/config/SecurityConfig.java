package com.mail.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mail.handler.SuccessRHnadler;
import com.mail.security.beans.MailUserDetailService;

@Configuration
@EnableWebSecurity
@ComponentScan("com.mail.security.beans,com.mail.security.dao,com.mail.handler")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger logger = Logger.getLogger(SecurityConfig.class);

	@Autowired
	BCryptPasswordEncoder bCrypt;

	@Autowired
	private SuccessRHnadler successHnadler;

	@Autowired
	private MailUserDetailService mailUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Enter into configure(HttpSecurity http) method");

		http.csrf().disable();
		/*
		http.authorizeRequests().antMatchers("/user.htm", "/home.htm").hasAuthority("customer").and().formLogin()
				.loginPage("/login.htm").usernameParameter("username").passwordParameter("password")
				.loginProcessingUrl("/j_login").successHandler(successHnadler).and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/home.htm").deleteCookies("JSESSIONID").and().rememberMe().key("uniqueAndSecret");
				
		*/

		http.authorizeRequests().antMatchers("/save-book.htm").hasAuthority("admin").and().formLogin()
				.loginPage("/login.htm").usernameParameter("username").passwordParameter("password")
				.loginProcessingUrl("/j_login").successHandler(successHnadler).and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/home.htm").deleteCookies("JSESSIONID").and().rememberMe().key("uniqueAndSecret");

		if (logger.isDebugEnabled())
			logger.debug("Exit configure(HttpSecurity http) method");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Enter into configure(AuthenticationManagerBuilder auth) method");

		auth.userDetailsService(mailUserDetailService).passwordEncoder(bCrypt);

		if (logger.isDebugEnabled())
			logger.debug("Exit configure(AuthenticationManagerBuilder auth) method");
	}

}
