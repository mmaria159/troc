package com.troc.service;

import com.troc.entity.Donation;

import java.util.List;

public interface DonationService {


    List<Donation> findAllDonations();

    Donation saveDonation(Donation donation);

    Donation findDonation(Long id);

}
