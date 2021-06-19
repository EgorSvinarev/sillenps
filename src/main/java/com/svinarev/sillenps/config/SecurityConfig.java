package com.svinarev.sillenps.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.svinarev.sillenps.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userSerivce;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
    	security.csrf().disable()
    		.authorizeRequests()
    			.antMatchers("/").permitAll()
    			.antMatchers("/account").hasAnyAuthority("ADMIN", "STUDENT", "TEACHER")
    			.antMatchers("/scripts/**", "/css/**", "/img/**", "/fonts/**").permitAll()
    		.anyRequest().authenticated()
    		.and()
    			.formLogin()
    			.loginPage("/auth")
    			.defaultSuccessUrl("/account")
    			.permitAll()
    		.and()
    			.logout()
    			.permitAll()
    			.logoutSuccessUrl("/");
    			
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userSerivce).passwordEncoder(getPasswordEncoder());
    }
    
}