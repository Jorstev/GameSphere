/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.controller;

import com.GameSphere.domain.noticias;
import com.GameSphere.service.impl.noticiasServiceImpl;
import com.GameSphere.service.noticiasService;
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
public class noticiasController {
    @Autowired
    private noticiasService NoticiasService;
    //private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/")
    public String getGames(Model model){
        var listaJuegos = NoticiasService.getNoticias();
        model.addAttribute("videojuegos", listaJuegos);
        return "index";
    }
    
    @GetMapping("/")
    public String noticiasNuevo(noticias Noticias) {
        return "//modifca";
    }

    @GetMapping("/guardar")
    public String noticiasGuardar(noticias Noticias, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            NoticiasService.save(Noticias);
           /* Noticias.setImagen_noticia(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "noticias",
                            Noticias.getId_noticia()
                    )
            );*/
        }
        NoticiasService.save(Noticias);
        return "redirect:/ / ";
    }

    @GetMapping("/eliminar/{id_noticias}")
    public String noticiasEliminar(noticias Noticias) {
        NoticiasService.delete(Noticias);
        return "redirect://";
    }

    @GetMapping("/modificar/{id_noticias}")
    public String noticiasModificar(noticias Noticias, Model model) {
        Noticias = NoticiasService.getNoticias(Noticias);
        model.addAttribute("noticias", Noticias);
        return "redirect://";
    }
}
