package com.getyourguide.supplier.security;

import com.getyourguide.supplier.properties.ServiceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class BasicAuthConfiguration {
    private final ServiceProperties serviceProperties;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            //.csrf().disable()
            .authorizeRequests().anyRequest().authenticated()
            .and()
            .httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        //TODO: This is for demonstration purpose only.
        // Please use more secured storage for the credentials

        UserDetails user = User
            .withUsername(serviceProperties.getSecurity().getUsername())
            .password(serviceProperties.getSecurity().getPassword())
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
