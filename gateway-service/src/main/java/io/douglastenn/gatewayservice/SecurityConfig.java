package io.douglastenn.gatewayservice;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public MapReactiveUserDetailsService authentication() {
        return new MapReactiveUserDetailsService(
                User.withDefaultPasswordEncoder()
                        .username("jamal")
                        .password("jamal")
                        .roles("USER")
                        .build()
        );
    }

    @Bean
    public SecurityWebFilterChain authorization(ServerHttpSecurity security) {
        return security
                .authorizeExchange().pathMatchers("/api/v1/beer/delay").authenticated()
                .anyExchange().permitAll()
                .and()
                .httpBasic()
                .and()
                .build();
    }

}
