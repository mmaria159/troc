package com.troc.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ImageDTO {
    private Long id;
    private String name;
    private String originalFileName;
    private Long size;
    private String contentType;
    private boolean isPreviewImage;
    private byte[] bytes;
}
