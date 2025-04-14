package com.example.event2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Plain text password (only for development)
    }

//---------------------------------------------formLogin()------------------------------------------------------------------

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/api/admin/hello").permitAll() // ✅ Make hello page publicly accessible
//                .requestMatchers("/api/admin/register", "/api/admin/login").permitAll() // Allow registration/login
//                .requestMatchers("/api/admin/**").hasAuthority("ADMIN") // Restrict other Admin endpoints
//                .anyRequest().authenticated()
//            )
//            .formLogin()
//            .defaultSuccessUrl("/dashboard", true)
//            .permitAll()
//            .and()
//            .logout()
//            .logoutUrl("/logout")
//            .logoutSuccessUrl("/login?logout=true")
//            .permitAll();
//
//        return http.build();
//    }
    
//---------------------------------------------httpBasic()------------------------------------------------------------------

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth.requestMatchers("/api/admin/hello").permitAll().requestMatchers("/api/admin/register", "/api/admin/login").permitAll() // Allow registration/login
                .requestMatchers("/api/admin/**").hasAuthority("ADMIN") // Restrict other Admin endpoints
                .anyRequest().authenticated()
            )
            .httpBasic() // Use Basic Authentication instead of default login page
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout=true")
            .permitAll();

        return http.build();
    }

    
  //---------------------------------------------formLogin() and httpBasic()--------------------------------------------------


//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http.csrf().disable()
//                .authorizeHttpRequests(auth -> auth
//                    .requestMatchers("/api/admin/hello").permitAll() // ✅ Publicly accessible
//                    .requestMatchers("/api/admin/register", "/api/admin/login").permitAll() // ✅ Open registration/login
//                    .requestMatchers("/api/admin/**").hasAuthority("ADMIN") // ✅ Protect admin routes
//                    .anyRequest().authenticated()
//                )
//                .formLogin(form -> form // ✅ Enables login form for browsers
//                    .defaultSuccessUrl("/dashboard", true)
//                    .permitAll()
//                )
//                .httpBasic(); // ✅ Enables Basic Authentication for Postman & API tools
//
//            return http.build();
//        }
//    



}


