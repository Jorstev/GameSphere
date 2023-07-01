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
    
}
