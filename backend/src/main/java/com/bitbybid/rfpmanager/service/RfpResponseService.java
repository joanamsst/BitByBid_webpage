package com.bitbybid.rfpmanager.service;

import com.bitbybid.rfpmanager.command.RfpFormDto;
import com.bitbybid.rfpmanager.converters.convertToDto.RfpFormToRfpFormDTO;
import com.bitbybid.rfpmanager.model.RfpForm;
import com.bitbybid.rfpmanager.repository.RfpResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RfpResponseService {

    @Autowired
    private RfpResponseRepository repository;

    public List<RfpFormDto> getResponsesByIds(List<Long> ids) {
        return repository.findAllById(ids)
                .stream()
                .map(RfpFormToRfpFormDTO::convert)
                .collect(Collectors.toList());
    }

    public List<RfpFormDto> searchByKeyword(String keyword) {
        return repository.findByProjectGoalContainingIgnoreCase(keyword)
                .stream()
                .map(RfpFormToRfpFormDTO::convert)
                .collect(Collectors.toList());
    }

    public List<RfpFormDto> searchByClient(String clientName) {
        return repository.findByCompanyName(clientName)
                .stream()
                .map(RfpFormToRfpFormDTO::convert)
                .collect(Collectors.toList());
    }

    public List<RfpFormDto> searchByBudgetRange(Double minPrice, Double maxPrice) {
        return repository.findByTotalPriceBetween(minPrice, maxPrice)
                .stream()
                .map(RfpFormToRfpFormDTO::convert)
                .collect(Collectors.toList());
    }

    public List<RfpFormDto> searchByDate(LocalDate rfpDate) {
        return repository.findByRfpDate(rfpDate)
                .stream()
                .map(RfpFormToRfpFormDTO::convert)
                .collect(Collectors.toList());
    }

    public List<RfpFormDto> searchByEndDateAfter(LocalDate endDate) {
        return repository.findByEndDateAfter(endDate)
                .stream()
                .map(RfpFormToRfpFormDTO::convert)
                .collect(Collectors.toList());
    }

    // Use raw RfpForm if needed for internal purposes like PDF export
    public List<RfpForm> getEntitiesByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    public List<RfpFormDto> searchRfps(String keyword) {
        List<RfpForm> rfps = repository.findByKeyword(keyword);
        return rfps.stream()
                .map(RfpFormToRfpFormDTO::convert)
                .collect(Collectors.toList());
    }

}
