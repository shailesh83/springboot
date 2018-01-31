package com.caveofprogramming.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.caveofprogramming.filters.ExpiredSessionFilter;

@Configuration
@Order(1)   
@EnableWebSecurity
public class RestSecurityConfig  extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
		
		http
			.antMatcher("/statuscheck")
				.authorizeRequests()
					.anyRequest()
					.permitAll()
					.and()
					.addFilterBefore(new ExpiredSessionFilter(), BasicAuthenticationFilter.class);
				
		// @formatter:on

	}

	
}