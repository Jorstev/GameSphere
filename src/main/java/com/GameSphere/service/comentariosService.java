/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GameSphere.service;

import com.GameSphere.domain.comentarios;
import java.util.List;

/**
 *
 * @author mfsv_
 */
public interface comentariosService {
    public List<comentarios> getComentarios();
    public comentarios getComentarios(comentarios Comentarios);
    public void saveC (comentarios Comentarios);
    public void deleteC (comentarios Comentarios);
    
}
