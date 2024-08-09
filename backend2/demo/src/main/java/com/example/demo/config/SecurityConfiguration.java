package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.service.AuthFilterService;

import lombok.RequiredArgsConstructor;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthFilterService authFilterService;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/**","/api/products/**", "/swagger-ui.html", "/swagger-ui/**")
                        .permitAll()
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()
                        .requestMatchers("/api/admin/**")  
                        .hasRole("ADMIN")  // Admin role requirement
                        .anyRequest()
                        .authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authFilterService, UsernamePasswordAuthenticationFilter.class);

        return http.build(); 
    }
}
 

// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.example.demo.service.AuthFilterService;

// import lombok.RequiredArgsConstructor;

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity
// @RequiredArgsConstructor
// public class SecurityConfiguration {

//     private final AuthFilterService authFilterService;
//     private final AuthenticationProvider authenticationProvider;

//     @Bean
//     public SecurityFilterChain swaggerSecurityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .csrf(csrf -> csrf.disable())
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers(
//                             "/swagger-ui/**", 
//                             "/v3/api-docs/**",
//                             "/swagger-ui.html",
//                             "/swagger-resources/**",
//                             "/webjars/**").permitAll())
//                 .sessionManagement(session -> session
//                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//         return http.build();
//     }

//     @Bean
//     public SecurityFilterChain adminSecurityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .csrf(csrf -> csrf.disable())
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/api/admin/**")  
//                         .hasRole("ADMIN")  // Admin role requirement
//                         .anyRequest()
//                         .authenticated())
//                 .sessionManagement(session -> session
//                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                 .authenticationProvider(authenticationProvider)
//                 .addFilterBefore(authFilterService, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }
// }
