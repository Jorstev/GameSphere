/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author JordanStevenChavarri
 */
@Data
@Entity
@Table(name = "videojuego")
public class videojuego implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private Long id_juego;
    private String nombre_juego;
    private double precio;
    private String desarrollador;
    private String fecha_lanzamiento;
    private String genero;
    private String descripcion_juego;
    private boolean lista_deseo;
    private String imagen_juego;

    public videojuego() {
    }

    public videojuego(String nombre_juego, double precio, String desarrollador, String fecha_lanzamiento, String genero, String descripcion_juego, boolean lista_deseo, String ruta_imagen) {
        this.nombre_juego = nombre_juego;
        this.precio = precio;
        this.desarrollador = desarrollador;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.genero = genero;
        this.descripcion_juego = descripcion_juego;
        this.lista_deseo = lista_deseo;
    }

  
}
