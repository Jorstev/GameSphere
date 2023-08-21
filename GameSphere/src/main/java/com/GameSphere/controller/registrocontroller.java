/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.controller;

import com.GameSphere.domain.Usuario;
import com.GameSphere.dao.UsuarioDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Joan Rojas
 */
@Controller
@Slf4j
@RequestMapping("/registro")
public class registrocontroller {
   
    
    @Autowired
    private UsuarioDao usuariodao;

    @GetMapping
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro"; // nombre de la vista
    }

    @PostMapping
    public String procesarFormularioRegistro(@ModelAttribute Usuario usuario) {
        // Aquí puedes realizar validaciones y luego guardar el usuario en la base de datos
        usuariodao.save(usuario);
        return "redirect:/login"; // redirigir a la página de inicio o a donde desees
    }
    }

