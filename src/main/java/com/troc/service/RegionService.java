package com.troc.service;

import com.troc.dto.ProductDTO;
import com.troc.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> findAllRegions();
}
