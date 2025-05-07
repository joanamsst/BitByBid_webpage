package com.bitbybid.rfpmanager.controller;

import com.bitbybid.rfpmanager.command.CompanyCertificationDto;

import com.bitbybid.rfpmanager.converters.convertToModel.CompanyCertificationDtoToEntity;
import com.bitbybid.rfpmanager.converters.convertToDto.CompanyCertificationToDto;

import com.bitbybid.rfpmanager.repository.CompanyCertificationRepository;
import com.bitbybid.rfpmanager.service.CompanyCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/certifications")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CompanyCertificationController {

    @Autowired
    private CompanyCertificationService service;

    @Autowired
    private CompanyCertificationRepository repository;

    @GetMapping
    public List<CompanyCertificationDto> getAll() {
        return repository.findAll().stream()
                .map(CompanyCertificationToDto::convert)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CompanyCertificationDto create(@RequestBody CompanyCertificationDto dto) {
        return CompanyCertificationToDto.convert(
                repository.save(CompanyCertificationDtoToEntity
                        .convert(dto))
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
