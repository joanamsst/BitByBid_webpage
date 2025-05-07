package com.bitbybid.rfpmanager.service;

import com.bitbybid.rfpmanager.command.CronogramDto;
import com.bitbybid.rfpmanager.converters.convertToDto.CronogramToCronogramDTO;
import com.bitbybid.rfpmanager.repository.ScheduleRepInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepInterface repository;

    public List<CronogramDto> getScheduleByRfpId(Long rfpId) {
        return repository.findByRfpFormRequestId(rfpId)
                .stream()
                .map(CronogramToCronogramDTO::convert)
                .collect(Collectors.toList());
    }
}
