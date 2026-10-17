
package com.klef.soa.exam.service;

import java.util.List;

import com.klef.soa.exam.entity.BloodDonationDrive;

public interface BloodDonationDriveService 
{

    BloodDonationDrive addBloodDonationDrive(
            BloodDonationDrive drive);

    List<BloodDonationDrive> displayAllBloodDonationDrives();

    String deleteBloodDonationDrive(Long id);
}
