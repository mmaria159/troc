package com.troc.service.impl;

import com.troc.entity.Region;
import com.troc.repository.RegionRepository;
import com.troc.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public List<Region> findAllRegions() {
        return regionRepository.findAll();
    }
}
