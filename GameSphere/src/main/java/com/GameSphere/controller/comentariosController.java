/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.controller;

import com.GameSphere.domain.comentarios;
import com.GameSphere.service.impl.comentariosServiceImpl;
import com.GameSphere.service.comentariosService;
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
 * @author mfsv_
 */

@Controller
@Slf4j
@RequestMapping("/comentarios")
public class comentariosController {
    
    @Autowired
    private comentariosService ComentariosService;
    
    @GetMapping("/comentarios")
    public String getComentarios(Model model){
        var listaComentarios = ComentariosService.getComentarios();
        model.addAttribute("comentarios", listaComentarios);
        return "/comentarios/comentarios";
    }
    
    @GetMapping("/agregar")
    public String comentariosNuevo(comentarios Comentarios) {
        return "/comentarios/agregar";
    }

    @PostMapping ("/guardar")
    public String comentariosGuardar(comentarios Comentarios) {
        ComentariosService.saveC(Comentarios);
        return "redirect:/comentarios/comentarios";
    }

    @GetMapping("/eliminar/{id_comentario}")
    public String comentariosEliminar(comentarios Comentarios) {
        ComentariosService.deleteC(Comentarios);
        return "redirect:/comentarios/comentarios";
    }

    @GetMapping("/modifica/{id_comentario}")
    public String comentariosModificar(comentarios Comentarios, Model model) {
        Comentarios = ComentariosService.getComentarios(Comentarios);
        model.addAttribute("comentarios", Comentarios);
        return "/comentarios/modifica";
    }
}
