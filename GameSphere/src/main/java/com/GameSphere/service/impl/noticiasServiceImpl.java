/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GameSphere.service.impl;

import com.GameSphere.dao.noticiasDao;
import com.GameSphere.domain.noticias;
import com.GameSphere.service.noticiasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author mfsv_
 */

@Service
public class noticiasServiceImpl implements noticiasService {

     @Autowired
     private noticiasDao NoticiasDao;
     
    @Override
    public List<noticias> getNoticias() {
        var Lista = NoticiasDao.findAll();
        return Lista;
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public noticias getNoticias(noticias Noticias) {
        return NoticiasDao.findById(Noticias.getId_noticia()).orElse(null);
    }

    @Override
    @Transactional
    public void save(noticias Noticias) {
        NoticiasDao.save(Noticias);
    }

    @Override
    @Transactional
    public void delete(noticias Noticias) {
        NoticiasDao.delete(Noticias);
    }
    
}
