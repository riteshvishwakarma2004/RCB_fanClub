package com.Ritesh.RCB_FanClub.config;

import com.Ritesh.RCB_FanClub.service.MyUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration {

    private MyUserDetailsService myUserDetailsService;

    public MySecurityConfiguration(MyUserDetailsService service){
        this.myUserDetailsService = service;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(myUserDetailsService);

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

//    @Bean
//    public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{
//         http
//                 .csrf(csrf -> csrf.disable())
//                 .authorizeHttpRequests(req -> req
//                         .requestMatchers(HttpMethod.POST, "/register","/login").permitAll()
//                         .requestMatchers("/home","/admin").permitAll()
//                         .requestMatchers("/dashboard").authenticated()
//                         .anyRequest().authenticated())
//                 .sessionManagement(session -> session
//                         .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
//                 .logout(logout -> logout.permitAll());
//
//         return http.build();
//
//
//    }

    @Bean
    public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers(HttpMethod.POST, "/register").permitAll()
                        .requestMatchers("/home","/registrationPage").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())


                .logout(logout -> logout.permitAll());
        return http.build();



    }
}
