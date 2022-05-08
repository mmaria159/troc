package com.troc.service;

import com.troc.entity.Image;
import org.springframework.stereotype.Repository;


public interface ImageService {
    Image saveImage(Image image);
}
