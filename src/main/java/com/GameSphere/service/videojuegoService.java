/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GameSphere.service;

import com.GameSphere.domain.videojuego;
import java.util.List;

/**
 *
 * @author JordanStevenChavarri
 */
public interface videojuegoService {
    public List<videojuego> getListaVideojuegos();
    public videojuego getVideojuego(videojuego Videojuego);
    public void save (videojuego Videojuego);
    public void delete (videojuego Videojuego);
}
