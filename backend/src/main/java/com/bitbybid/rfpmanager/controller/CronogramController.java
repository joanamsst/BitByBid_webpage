package com.bitbybid.rfpmanager.controller;

import com.bitbybid.rfpmanager.command.CronogramDto;
import com.bitbybid.rfpmanager.converters.convertToModel.CronogramDTOToCronogram;
import com.bitbybid.rfpmanager.converters.convertToDto.CronogramToCronogramDTO;
import com.bitbybid.rfpmanager.repository.ScheduleRepInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cronogram")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CronogramController {

    @Autowired
    private ScheduleRepInterface repository;

    @GetMapping
    public List<CronogramDto> getAll() {
        return repository.findAll().stream()
                .map(CronogramToCronogramDTO::convert)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CronogramDto create(@RequestBody CronogramDto dto) {
        return CronogramToCronogramDTO.convert(
                repository.save(CronogramDTOToCronogram.convert(dto))
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
