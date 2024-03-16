package com.leandrokhalel.goomerlistarango.controller;

import com.leandrokhalel.goomerlistarango.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload/restaurants/{restaurantId}")
    public ResponseEntity<?> upload(@RequestPart("image")MultipartFile file, @PathVariable Long restaurantId) throws Exception {

        var image = this.imageService.save(file, restaurantId);
        var body = new ByteArrayResource(image.getData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, image.getMimeType())
                .body(body);
    }
}
