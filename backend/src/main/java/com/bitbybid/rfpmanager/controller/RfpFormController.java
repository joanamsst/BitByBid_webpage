package com.bitbybid.rfpmanager.controller;

import com.bitbybid.rfpmanager.command.RfpFormDto;
import com.bitbybid.rfpmanager.converters.convertToModel.RfpFormDTOToRfpForm;
import com.bitbybid.rfpmanager.converters.convertToDto.RfpFormToRfpFormDTO;
import com.bitbybid.rfpmanager.model.RfpForm;
import com.bitbybid.rfpmanager.repository.RfpResponseRepository;
import com.bitbybid.rfpmanager.service.pdfServiceLayer.PdfExportService;
import com.bitbybid.rfpmanager.service.RfpResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rfp")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RfpFormController {

    @Autowired
    private RfpResponseRepository rfpResponseRepository;

    @Autowired
    private PdfExportService pdfExportService;

    @Autowired
    private RfpResponseService responseService;

    @GetMapping
    public List<RfpFormDto> getAll() {
        return rfpResponseRepository.findAll().stream()
                .map(RfpFormToRfpFormDTO::convert)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RfpFormDto getById(@PathVariable Long id) {
        return rfpResponseRepository.findById(id)
                .map(RfpFormToRfpFormDTO::convert)
                .orElse(null);
    }

    @PostMapping
    public RfpFormDto create(@RequestBody RfpFormDto dto) {
        RfpForm saved = rfpResponseRepository.save(RfpFormDTOToRfpForm.convert(dto));
        return RfpFormToRfpFormDTO.convert(saved);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rfpResponseRepository.deleteById(id);
    }

    @GetMapping("/export-pdf")
    public ResponseEntity<InputStreamResource> exportToPdf(@RequestParam List<Long> ids) {
        List<RfpForm> selectedResponses = responseService.getEntitiesByIds(ids); // raw entity for PDF
        ByteArrayInputStream bis = pdfExportService.exportToPdf(selectedResponses);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=rfp-response.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @GetMapping("/search")
    public ResponseEntity<List<RfpFormDto>> searchRfps(@RequestParam String keyword) {
        List<RfpFormDto> results = responseService.searchRfps(keyword);
        return ResponseEntity.ok(results);
    }

}
