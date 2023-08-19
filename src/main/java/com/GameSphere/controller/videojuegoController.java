/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.controller;

import com.GameSphere.domain.videojuego;
import com.GameSphere.service.FirebaseStorageService;
import com.GameSphere.service.impl.FirebaseStorageServiceImpl;

import com.GameSphere.service.videojuegoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author JordanStevenChavarri
 */
@Controller
@Slf4j
@RequestMapping("/producto")
public class videojuegoController {

    @Autowired
    private videojuegoService videojuegoService;

    @GetMapping("/videojuegos")
    public String getGames(Model model) {
        var listaJuegos = videojuegoService.getListaVideojuegos();
        model.addAttribute("videojuegos", listaJuegos);
        return "/producto/videojuegos";
    }

    @GetMapping("/videojuegoAgregar")
    public String videojuegoAgregar(Model model) {
        return "/producto/videojuegoAgregar";
    }

    @GetMapping("/eliminar/{id_juego}")
    public String videojuegoEliminar(videojuego Videojuego) {
        videojuegoService.delete(Videojuego);
        return "redirect:/producto/videojuegos";
    }
//    

    @GetMapping("/videojuegoInfo/{id_juego}")
    public String ReadVideoJuego(videojuego Videojuego, Model model) {
        var VideojuegoDetalle = videojuegoService.getVideojuego(Videojuego);
        model.addAttribute("detalleVideoJuego", VideojuegoDetalle);
        return "/producto/videojuegoInfo";
    }

    @GetMapping("/videojuegoEditar/{id_juego}")
    public String ModificarVideoJuego(videojuego Videojuego, Model model) {
        Videojuego = videojuegoService.getVideojuego(Videojuego);
        model.addAttribute("detalleVideoJuego", Videojuego);
        return "/producto/videojuegoEditar";
    }
    @Autowired
    private FirebaseStorageServiceImpl FirebaseStorageService;

    @PostMapping("/guardar")
    public String videojuegoGuardar(videojuego Videojuego, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            videojuegoService.save(Videojuego);
            Videojuego.setImagen_juego(
                    FirebaseStorageService.cargaImagen(imagenFile, "Videojuego", Videojuego.getId_juego()));
        }
        videojuegoService.save(Videojuego);
        return "redirect:/producto/videojuegos";
    }

    //@PostMapping("/guardar")
    //public String videojuegoGuardar(videojuego Videojuego) {
    //  videojuegoService.save(Videojuego);
    //return "redirect:/producto/videojuegos";
    //}
}
