package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

 public PasswordEncoder passwordEncoder(){
     return new BCryptPasswordEncoder();
 }

 @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
     http
             .csrf(csrf -> csrf.disable())
             .authorizeHttpRequests(authorize -> authorize
             .requestMatchers("/api/clientes/**").permitAll());
    return http.build();
 }


}
