package com.troc.service.impl;

import com.troc.entity.Image;
import com.troc.entity.Product;
import com.troc.repository.ImageRepository;
import com.troc.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ProductServiceImpl productService;

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> saveImage(List<Image> images, Long productId) {
        Product product = productService.findProductById(productId);
        for (Image image : images) {
            product.addImage(image);
        }
        productService.saveProduct(product);
//        return imageRepository.saveAll(images);
        return images;
    }

    public Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
