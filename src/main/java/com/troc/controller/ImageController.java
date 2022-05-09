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
import java.util.ArrayList;
import java.util.List;

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

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<List<Image>> saveImage(@RequestPart("files") List<MultipartFile> files) throws IOException {
        List<Image> images = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file.getSize() != 0) {
                images.add(imageService.toImageEntity(file));
            }
        }
        return new ResponseEntity<>(imageService.saveImage(images), HttpStatus.OK);
    }
}