package com.example.Ejercicio.DB0.Security;

import com.example.Ejercicio.DB0.filter.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/estudiante").permitAll()
                .antMatchers(HttpMethod.GET, "/persona").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST, "/persona").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/persona").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/persona").hasRole("ADMIN")
                .anyRequest().authenticated();
    }




}
