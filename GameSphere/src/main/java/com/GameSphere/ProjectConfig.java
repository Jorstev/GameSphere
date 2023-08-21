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

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        registry.addViewController("/registro").setViewName("/registro");
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
                       "/index", "/producto/videojuegos", "/producto/videojuegoAgregar", "/producto/videojuegoEditar/1", "/producto/videojuegoEditar/2", "/producto/videojuegoEditar/3", "/producto/videojuegoEditar/4","/producto/eliminar/1", "/producto/eliminar/2", "/producto/eliminar/3", "/producto/eliminar/4","/producto/guardar",
                        "/producto/videojuegoInfo/1", "/producto/videojuegoInfo/2", "/producto/videojuegoInfo/3", "/producto/videojuegoInfo/4",
                        
                        "/noticias/noticias",  "/noticias/modifica/1", "/noticias/modifica/2", "/noticias/modifica/3" , "/noticias/agregar", "/noticias/eliminar/1", "/noticias/eliminar/2", "/noticias/eliminar/3","/noticias/guardar",
                        "/noticias/noticiaView/1", "/noticias/noticiaView/2", "/noticias/noticiaView/3", "/comentarios/agregar","/comentarios/guardar","/comentarios/modifica/1","/comentarios/modifica/2","/comentarios/modifica/3","/comentarios/eliminar/1","/comentarios/eliminar/2","/comentarios/eliminar/3",
                        "/comentarios/comentarios" 
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



