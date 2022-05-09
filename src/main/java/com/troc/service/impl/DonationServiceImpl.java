package com.troc.service.impl;

import com.troc.entity.Donation;
import com.troc.exceptions.UserNotFoundException;
import com.troc.repository.DonationRepository;
import com.troc.service.DonationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {
    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public List<Donation> findAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Donation findDonation(Long id) {
        Donation donation= donationRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found by id:" + id));
        return donation;
    }

    @Override
    public Donation saveDonation(Donation donation) {
        return donationRepository.save(donation);
    }
}
