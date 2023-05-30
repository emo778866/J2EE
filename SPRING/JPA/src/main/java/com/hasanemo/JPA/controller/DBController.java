package com.hasanemo.JPA.controller;


import com.hasanemo.JPA.model.Pharmacy;
import com.hasanemo.JPA.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pharmacy")
public class DBController {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @PostMapping("/new")
    public void createNewPharmacy(@RequestBody Pharmacy pharmacy) {
        pharmacyRepository.save(pharmacy);
    }

    @GetMapping("/find/{id}")
    public Pharmacy findPharmacyById(@PathVariable Long id) {
        return pharmacyRepository.findPharmacyById(id);
    }

}
