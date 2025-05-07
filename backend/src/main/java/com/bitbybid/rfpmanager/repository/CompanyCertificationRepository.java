package com.bitbybid.rfpmanager.repository;

import com.bitbybid.rfpmanager.model.CompanyCertification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyCertificationRepository extends JpaRepository<CompanyCertification, Long> {

    // Get all certifications related to an RFP
    List<CompanyCertification> findByRfpFormRequestId(Long requestId);

}