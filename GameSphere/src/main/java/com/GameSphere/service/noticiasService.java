/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GameSphere.service;

import com.GameSphere.domain.noticias;
import java.util.List;

/**
 *
 * @author mfsv_
 */
public interface noticiasService {
    
    public List<noticias> getNoticias();
    public noticias getNoticias(noticias Noticias);
    public void save (noticias Noticias);
    public void delete (noticias Noticias);
    
}
