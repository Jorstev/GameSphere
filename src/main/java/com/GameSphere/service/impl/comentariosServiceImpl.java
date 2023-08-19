/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.service.impl;

import com.GameSphere.dao.comentariosDao;
import com.GameSphere.domain.comentarios;
import com.GameSphere.service.comentariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class comentariosServiceImpl implements comentariosService {

     @Autowired
     private comentariosDao ComentariosDao;
     
    @Override
    public List<comentarios> getComentarios() {
        var Lista = ComentariosDao.findAll();
        return Lista;
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public comentarios getComentarios (comentarios Comentarios) {
        return ComentariosDao.findById(Comentarios.getId_comentario()).orElse(null);
    }

    @Override
    @Transactional
    public void saveC (comentarios Comentarios) {
        ComentariosDao.save(Comentarios);
    }
    

    @Override
    @Transactional
    public void deleteC (comentarios Comentarios) {
        ComentariosDao.delete(Comentarios);
    }
    
}
