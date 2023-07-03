/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.service.impl;

import com.GameSphere.dao.videojuegoDao;
import com.GameSphere.domain.videojuego;
import com.GameSphere.service.videojuegoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JordanStevenChavarri
 */
@Service
public class videojuegoServiceImpl implements videojuegoService {
    
    @Autowired
    private videojuegoDao videojuegoDao;

    @Override
    public List<videojuego> getListaVideojuegos() {
        var lista = videojuegoDao.findAll();
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public videojuego getVideojuego(videojuego Videojuego) {
        return videojuegoDao.findById(Videojuego.getId_juego()).orElse(null);
    }

    @Override
    @Transactional
    public void save(videojuego Videojuego) {
        videojuegoDao.save(Videojuego);
    }

    @Override
    @Transactional
    public void delete(videojuego Videojuego) {
       videojuegoDao.delete(Videojuego);
    }
    
}
