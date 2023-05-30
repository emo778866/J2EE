package com.hasanemo.JPA.repository;

import com.hasanemo.JPA.model.Pharmacy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends CrudRepository<Pharmacy, Long> {

    Pharmacy findPharmacyById(Long pharmacyId);

}
