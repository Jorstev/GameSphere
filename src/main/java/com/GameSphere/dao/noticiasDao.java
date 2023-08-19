/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GameSphere.dao;

import com.GameSphere.domain.noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mfsv_
 */
@Repository
public interface noticiasDao extends JpaRepository<noticias, Long>{
    
    
}
