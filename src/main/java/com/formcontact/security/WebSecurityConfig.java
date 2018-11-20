package com.formcontact.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 https://github.com/auth0-blog/spring-boot-jwts/blob/master/src/main/java/com/example/security/WebSecurityConfig.java
	*/

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/*").permitAll()  
			.antMatchers(HttpMethod.GET, "/").permitAll()
			.antMatchers(HttpMethod.OPTIONS,"/").permitAll()  
			.antMatchers("/info").permitAll()
			.antMatchers(HttpMethod.POST, "/Contato").permitAll()	
			.antMatchers(HttpMethod.GET, "/Contatos").permitAll()				
			.antMatchers(HttpMethod.DELETE, "/Contato/").permitAll()

			.anyRequest().authenticated()
			.and()
			
			 //filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
			
			 //filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// cria uma conta default
		// TODO setup JBDC authentication
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("admin")
			.roles("ADMIN");
	}
} 
