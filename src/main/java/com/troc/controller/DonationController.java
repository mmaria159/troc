package com.troc.controller;

import com.troc.entity.Donation;
import com.troc.service.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donations")
public class DonationController {
    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Donation>> findAllDonation() {
        return new ResponseEntity<>(donationService.findAllDonations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public Donation findDonation(@PathVariable Long id) {
        return donationService.findDonation(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<Donation> saveDonation(@RequestBody Donation donation) {
        return new ResponseEntity<>(donationService.saveDonation(donation), HttpStatus.OK);
    }
}
