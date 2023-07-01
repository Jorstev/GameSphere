/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.controller;

import com.GameSphere.service.impl.videojuegoServiceImpl;
import com.GameSphere.service.videojuegoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author JordanStevenChavarri
 */
@Controller
@Slf4j

public class videojuegoController{
    
    @Autowired
    private videojuegoService videojuegoService;
    
    @GetMapping("/")
    public String getGames(Model model){
        var listaJuegos = videojuegoService.getListaVideojuegos();
        model.addAttribute("videojuegos", listaJuegos);
        return "index";
    }
    
}
