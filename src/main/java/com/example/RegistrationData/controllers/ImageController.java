package com.example.RegistrationData.controllers;

import com.example.RegistrationData.repositories.InputDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ImageController {

    @Autowired
    private InputDataRepository inputDataRepository;

    // View all data (including images)
    @GetMapping("/data/view/{id}")
    public ResponseEntity<ByteArrayResource> viewImage(@PathVariable Long id) {
        byte[] image = inputDataRepository.getImageById(id);
        
        if (image == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)  // Assuming the image is JPEG, adjust if needed
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"image.jpg\"")
                .body(new ByteArrayResource(image));
    }
}
