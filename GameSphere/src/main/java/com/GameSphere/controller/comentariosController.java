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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mfsv_
 */

@Controller
@Slf4j
@RequestMapping("/noticias")
public class comentariosController {
    /*
    @Autowired
    private comentariosService ComentariosService;
    
    @GetMapping("/noticias")
    public String getComentarios(Model model){
        var listaComentarios = ComentariosService.getComentarios();
        model.addAttribute("comentarios", listaComentarios);
        return "/noticias/noticias";
    }
    
    @GetMapping("/nuevo")
    public String comentariosNuevo(comentarios Comentarios) {
        return "/noticias/modifca";
    }

    @GetMapping("/guardar")
    public String comentariosGuardar(comentarios Comentarios, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            ComentariosService.saveC(Comentarios);
           /*Comentarios.setImagen_noticia(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "noticias",
                            Comentarios.getId_comentario()
                    )
            );*/ /*
        }
        ComentariosService.saveC(Comentarios);
        return "redirect:/noticias/noticias";
    }

    @GetMapping("/eliminar/{id_comentario}")
    public String comentariosEliminar(comentarios Comentarios) {
        ComentariosService.deleteC(Comentarios);
        return "redirect:/noticias/noticias";
    }

    @GetMapping("/modifica/{id_comentario}")
    public String comentariosModificar(comentarios Comentarios, Model model) {
        Comentarios = ComentariosService.getComentarios(Comentarios);
        model.addAttribute("comentarios", Comentarios);
        return "redirect:/noticias/noticias";
    }*/
}
