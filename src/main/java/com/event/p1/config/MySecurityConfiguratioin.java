package com.event.p1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.event.p1.service.MyUserDetailsService;

@Configuration
@EnableMethodSecurity
public class MySecurityConfiguratioin {
	@Autowired
	private MyUserDetailsService muds;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setPasswordEncoder(passwordEncoder());
		auth.setUserDetailsService(muds);
		return auth;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return 	config.getAuthenticationManager();
	}
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf(csrf -> csrf.disable())       		
//        		
//                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/**").permitAll())
//                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v2/**").authenticated())
////                
//                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider())
////                  
//                .build();
//    }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http.csrf(csrf -> csrf.disable())
	    		.authorizeHttpRequests(auth -> auth
	    		.requestMatchers("/user/**").permitAll()
	    		.requestMatchers("/data/**","/api/v3/**","/Event/**","/eventtypes/**","/food/**","/locations/**","/music/**","/payment/**").authenticated())
		        .httpBasic(Customizer.withDefaults())  
		        .authenticationProvider(authenticationProvider())
		        .build();
	}

	
	
}
