/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GameSphere.service;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author JordanStevenChavarri
 */
public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    final String BucketName = "gamesphere-3f926.appspot.com";
    
    final String rutaSuperiorStorage = "gamesphere";
    
    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "gamesphere-3f926-firebase-adminsdk-4ngy6-fa19cd3c7b";
}
