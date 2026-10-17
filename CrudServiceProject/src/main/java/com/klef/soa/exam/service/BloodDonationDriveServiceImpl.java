
package com.klef.soa.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.soa.exam.entity.BloodDonationDrive;
import com.klef.soa.exam.repository.BloodDonationDriveRepository;

@Service
public class BloodDonationDriveServiceImpl
        implements BloodDonationDriveService
        {

    private final BloodDonationDriveRepository repository;

    public BloodDonationDriveServiceImpl(
            BloodDonationDriveRepository repository) 
    {
        this.repository = repository;
    }

    @Override
    public BloodDonationDrive addBloodDonationDrive(
            BloodDonationDrive drive) 
    {
        return repository.save(drive);
    }

    @Override
    public List<BloodDonationDrive> displayAllBloodDonationDrives() 
    {
        return repository.findAll();
    }

    @Override
    public String deleteBloodDonationDrive(Long id) 
    {

        boolean status = repository.existsById(id);

        if (status)
        {
            repository.deleteById(id);
            return "Blood Donation Drive Deleted Successfully";
        } 
        else 
        {
            return "Blood Donation Drive ID not found";
        }
    }
}
