package com.restCrud.crudRest2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class securityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john = User.builder().
//                username("john").
//                password("{noop}test123").
//                roles("EMPLOYEE")
//                .build();
//
//        UserDetails susan = User.builder().
//                username("susan").
//                password("{noop}test123").
//                roles("EMPLOYEE, MANAGER")
//                .build();
//
//        UserDetails mary = User.builder().
//                username("mary").
//                password("{noop}test123").
//                roles("EMPLOYEE, MANAGER, ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan);
//
//    }

    //add support for jdbc
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve data by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );

        //define query to retrieve authorities by username
        jdbcUserDetailsManager.setGroupAuthoritiesByUsernameQuery(
                "select user_id, roles from roles where user_id=?"
        );

        return new JdbcUserDetailsManager(dataSource);
    }
    //now spring can access from database


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       http.authorizeHttpRequests(
               configurer->
                       configurer
                       .requestMatchers(HttpMethod.GET, "api/employees").hasRole("EMPLOYEE")
                       .requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
                       .requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
                       .requestMatchers(HttpMethod.PUT, "api/employees").hasRole("MANAGER")
                       .requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")

       );
       //USE HTTP BASIC AUTHENTICATION
       http.httpBasic();

       //disable cross site request forgery
        // in general not required for stateless rest api that use post, put, delete and patch
       http.csrf().disable();

       return http.build();
    }
}
