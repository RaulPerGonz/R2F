package com.example.rpg0904.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(
    AuthenticationConfiguration authenticationConfiguration)
    throws Exception {return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/rutinas/**").permitAll()
                .antMatchers("/rutina/**").permitAll()
                .antMatchers("/new/**").hasAnyRole("MANAGER","ADMIN")
                .antMatchers("/valoracion/new/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/valoracion/edit/**").hasRole("ADMIN")
                .antMatchers("/valoracion/delete/**").hasRole("ADMIN")
                .antMatchers("/edit/**").hasAnyRole("MANAGER","ADMIN")
                .antMatchers("/delete/**").hasAnyRole("MANAGER","ADMIN")
                .antMatchers("/webjars/**", "/css/**", "/images/**").permitAll() // rec.estaticos
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessError");
        return http.build();
    }
}
