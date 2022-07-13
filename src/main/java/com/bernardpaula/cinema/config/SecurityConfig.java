package com.bernardpaula.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public static final String[] PUBLIC_MATCHERS = {
		"/h2-console/**",
			
	};
	
	public static final String[] PUBLIC_MATCHERS_GET = {
			"/atores/**",
			"/salas/**"		
		};
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.cors().and().csrf().disable();     
		http.authorizeRequests((authz) -> authz
				.anyRequest().authenticated()
				);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		return http.build();
	}
	
	 @Bean
	 public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().antMatchers(PUBLIC_MATCHERS)
	        								.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET);
	    }
	
	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	 
	/*
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	*/
}
