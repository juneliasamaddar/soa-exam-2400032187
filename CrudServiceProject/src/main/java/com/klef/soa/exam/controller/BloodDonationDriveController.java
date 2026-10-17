
package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.exam.entity.BloodDonationDrive;
import com.klef.soa.exam.service.BloodDonationDriveService;

@CrossOrigin("*")
@RestController
@RequestMapping("/blooddonationdrive")
public class BloodDonationDriveController 
{

    private final BloodDonationDriveService service;

    public BloodDonationDriveController(BloodDonationDriveService service) 
    {
        this.service = service;
    }

    @GetMapping("/")
    public String home() 
    {
        return "CRUD Service is running";
    }
    
    @Value("${server.port}")
    private String port;
    
    @GetMapping("/instance")
    public String instance()
    {
    	return "CRUD Service Project is running on port: " + port;
    }


    @PostMapping("/add")
    public ResponseEntity<BloodDonationDrive> addBloodDonationDrive(@RequestBody BloodDonationDrive drive) 
    {

        BloodDonationDrive savedDrive =
                service.addBloodDonationDrive(drive);

        return new ResponseEntity<>(savedDrive, HttpStatus.CREATED);
    }

    @GetMapping("/displayAll")
    public ResponseEntity<List<BloodDonationDrive>> displayAll() 
    {
        return ResponseEntity.ok(service.displayAllBloodDonationDrives());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) 
    {

        service.deleteBloodDonationDrive(id);

        return ResponseEntity.ok("Blood donation drive deleted successfully");
    }
}
