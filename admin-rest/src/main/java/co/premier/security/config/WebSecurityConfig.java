package co.premier.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.premier.security.filter.JwtFilter;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
		.and()
		.addFilterAfter(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/login/**")
		.permitAll()
		.anyRequest()
		.authenticated();
	}
}
