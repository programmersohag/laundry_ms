package com.sohag.laundry_backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(form ->
                        form.loginPage("/user/login").permitAll()
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/dashboard", true)
                                .failureUrl("/user/login?error")
                )
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/vendor/**", "/css/**", "/js/**", "/img/**").permitAll()
                                .requestMatchers("/user/signup").permitAll()
                                .anyRequest().authenticated())

                .build();

    }

/*    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }*/
}
