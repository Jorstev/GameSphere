/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author USUARIO
 */
@Configuration
public class ProjectConfig implements WebMvcConfigurer {

     // Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto 
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/error/**",
                        "/carrito/**",
                        "/registro/**", "/js/**", "/webjars/**", "/css/**", "/images/**")
                .permitAll()
                .requestMatchers(
                       "/index", "/producto/videojuegos", "/noticias/noticias", "/comentarios/comentarios"
                ).hasAnyRole("ADMIN" , "USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

   /* @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("juan")
                .password("{noop}123") // {noop} indica que no se aplica ningún algoritmo de encriptación
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("pedro")
                .password("{noop}789")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }*/


    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
        // Configurar el AuthenticationManagerBuilder
        build.userDetailsService(userDetailsService) // Usar UserDetailsService para cargar detalles del usuario
            .passwordEncoder(new BCryptPasswordEncoder()); // Utilizar BCryptPasswordEncoder para cifrar contraseñas
    }
}



