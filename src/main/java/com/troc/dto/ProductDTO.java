package com.troc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.troc.entity.Category;
import com.troc.entity.Region;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dateOfCreated;
    private Category category;
    private Region region;
}
