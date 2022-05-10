package com.troc.mapper;

import com.troc.dto.ImageDTO;
import com.troc.entity.Image;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageMapper {
    public ImageDTO mapToImageDto(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .name(image.getName())
                .originalFileName(image.getOriginalFileName())
                .size(image.getSize())
                .contentType(image.getContentType())
                .isPreviewImage(image.isPreviewImage())
                .bytes(image.getBytes())
                .build();
    }

    public List<ImageDTO> mapToImageDto(List<Image> images) {
        return images.stream().map(this::mapToImageDto).collect(Collectors.toList());
    }
}
