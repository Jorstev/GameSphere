/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.controller;

import com.GameSphere.domain.videojuego;
import com.GameSphere.service.impl.videojuegoServiceImpl;
import com.GameSphere.service.videojuegoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author JordanStevenChavarri
 */
@Controller
@Slf4j

public class videojuegoController{
    
    @Autowired
    private videojuegoService videojuegoService;
    //private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/")
    public String getGames(Model model){
        var listaJuegos = videojuegoService.getListaVideojuegos();
        model.addAttribute("videojuegos", listaJuegos);
        return "index";
    }
    
    @GetMapping("/")
    public String noticiasNuevo(videojuego Videojuego) {
        return "//modifca";
    }

    @GetMapping("/guardar")
    public String noticiasGuardar(videojuego Videojuego, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            videojuegoService.save(Videojuego);
          /*Noticias.setImagen_videojuego(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "videojuego",
                            Videojuego.getId_videojuego()
                    )
            );*/
        }
        videojuegoService.save(Videojuego);
        return "redirect:/ / ";
    }

    @GetMapping("/eliminar/{id_noticias}")
    public String noticiasEliminar(videojuego Videojuego) {
        videojuegoService.delete(Videojuego);
        return "redirect://";
    }

    @GetMapping("/modificar/{id_noticias}")
    public String noticiasModificar(videojuego Videojuego, Model model) {
        Videojuego = videojuegoService.getVideojuego(Videojuego);
        model.addAttribute("videojuego", Videojuego);
        return "redirect://";
    }
    
}
