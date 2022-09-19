package com.halfmoonyoga.studio;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable()).authorizeRequests(auth -> {
            // for now, allowing access to all routes for dev
            auth.antMatchers("/").permitAll();
            auth.antMatchers("/students").permitAll();
        }).httpBasic(Customizer.withDefaults()).build();
    }
}
