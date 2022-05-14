package com.troc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.troc.entity.Category;
import com.troc.entity.Image;
import com.troc.entity.Region;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    private String name;

    private String description;
    private String moreInformation;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dateOfCreated;

    private Category category;

    private Region region;

    private List<ImageDTO> images;
}
