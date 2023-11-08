package com.getYourCouse.getYourCouse.sec;


import com.getYourCouse.getYourCouse.sec.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    SecurityFilterChain securityChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                                authorizeRequests
                                        .requestMatchers("admin/**").hasRole("admin")
                                        .requestMatchers("user/**").hasRole("user")
                                        .requestMatchers("/").permitAll()
                                        .anyRequest().authenticated()
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.accessDeniedPage("/403")
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .userDetailsService(userDetailsServiceImpl);
        return http.build();
    }


}
