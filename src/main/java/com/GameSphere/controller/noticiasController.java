/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.controller;

import com.GameSphere.domain.noticias;
import com.GameSphere.service.impl.FirebaseStorageServiceImpl;
import com.GameSphere.service.impl.noticiasServiceImpl;
import com.GameSphere.service.noticiasService;
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
@RequestMapping("/noticias")
public class noticiasController {
    @Autowired
    private noticiasService NoticiasService;
    @Autowired
    private FirebaseStorageServiceImpl FirebaseStorageService;
    
    @GetMapping("/noticias")
    public String getNoticias(Model model){
        var listaNoticias = NoticiasService.getNoticias();
        model.addAttribute("noticias", listaNoticias);
        return "/noticias/noticias";
    }
    
    @GetMapping("/agregar")
    public String noticiasNuevo(noticias Noticias) {
        return "/noticias/agregar";
    }

    @PostMapping("/guardar")
    public String noticiasGuardar(noticias Noticias, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            NoticiasService.saveN(Noticias);
            Noticias.setImagen_noticia(
                    FirebaseStorageService.cargaImagen(imagenFile, "Noticias", Noticias.getId_noticia()));
        }
        NoticiasService.saveN(Noticias);
        return "redirect:/noticias/noticias";
    }

    @GetMapping("/eliminar/{id_noticia}")
    public String noticiasEliminar(noticias Noticias) {
        NoticiasService.deleteN(Noticias);
        return "redirect:/noticias/noticias";
    }
    @GetMapping("/modifica/{id_noticia}")
    public String noticiasModificar(noticias Noticias, Model model) {
        Noticias = NoticiasService.getNoticias(Noticias);
        model.addAttribute("noticias", Noticias);
        return "/noticias/modifica";
    }
    
    @GetMapping("/noticiaView/{id_noticia}")
    public String viewNoticia(noticias Noticias, Model model) {
        var noticiaEspecifica = NoticiasService.getNoticias(Noticias);
        model.addAttribute("noticiaEspecifica", noticiaEspecifica);
        return "/noticias/noticiaView";
    }
}
