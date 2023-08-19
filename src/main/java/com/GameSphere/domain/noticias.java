/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author mfsv_
 */

@Data
@Entity
@Table(name = "noticias")
public class noticias implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private Long id_noticia;
    private String titulo_noticia;
    private String fecha_publicacion; 
    private String descripcion_noticia;
    private String imagen_noticia;

    public noticias() {
        
    }

    public noticias(String titulo_noticia, String fecha_publicacion, String descripcion_noticia, String ruta_imagen) {
        this.titulo_noticia = titulo_noticia;
        this.fecha_publicacion = fecha_publicacion;
        this.descripcion_noticia = descripcion_noticia;
        this.imagen_noticia = ruta_imagen;
    }   
}
