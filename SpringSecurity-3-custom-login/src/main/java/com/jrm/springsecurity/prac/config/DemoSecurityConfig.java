package com.jrm.springsecurity.prac.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	//add reference to security data source
	
	@Autowired
	//private DataSource securityDatasource;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//add default users
		
		
		  UserBuilder user = User.withDefaultPasswordEncoder();
		  auth.inMemoryAuthentication()
		  .withUser(user.username("jrm").password("123").roles("EMPLOYEE"))
		  .withUser(user.username("srm").password("123").roles("MANAGER"))
		  .withUser(user.username("crm").password("123").roles("ADMIN"));
		 
		
		//use jdbc auth
		
		//auth.jdbcAuthentication().dataSource(securityDatasource);		
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasAnyRole("EMPLOYEE","MANAGER")
		.antMatchers("/manager").hasRole("MANAGER")
		.antMatchers("/admin").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/mylogin") ///custom login url
			.loginProcessingUrl("/authuser") //custom processing url
			.permitAll() // permits all to view the login url
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied")
		;
	}
	
	
	
	

}
