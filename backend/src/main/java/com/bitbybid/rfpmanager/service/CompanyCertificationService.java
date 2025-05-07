package com.bitbybid.rfpmanager.service;

import com.bitbybid.rfpmanager.command.CompanyCertificationDto;
import com.bitbybid.rfpmanager.converters.convertToDto.CompanyCertificationToDto;
import com.bitbybid.rfpmanager.repository.CompanyCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyCertificationService {

    @Autowired
    private CompanyCertificationRepository repository;

    public List<CompanyCertificationDto> getCertificationsByRfpId(Long rfpId) {
        return repository.findByRfpFormRequestId(rfpId)
                .stream()
                .map(CompanyCertificationToDto::convert)
                .collect(Collectors.toList());
    }
}
