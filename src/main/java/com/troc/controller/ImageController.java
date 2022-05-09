package com.troc.controller;

import com.troc.entity.Image;
import com.troc.repository.ImageRepository;
import com.troc.service.impl.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;
    private final ImageServiceImpl imageService;

    @GetMapping("/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

    @PostMapping
    public ResponseEntity<Image> saveImage(@RequestParam MultipartFile file1) throws IOException {
        Image image = null;
        if (file1.getSize() != 0) {
            image = imageService.toImageEntity(file1);
            image.setPreviewImage(true);
        }
        return new ResponseEntity<>(imageService.saveImage(image), HttpStatus.OK);
    }
}