package com.bitbybid.rfpmanager.converters.convertToDto;

import com.bitbybid.rfpmanager.command.CompanyCertificationDto;
import com.bitbybid.rfpmanager.model.CompanyCertification;

public class CompanyCertificationToDto {

    public static CompanyCertificationDto convert(CompanyCertification entity) {
        CompanyCertificationDto dto = new CompanyCertificationDto();
        dto.setId(entity.getId());
        dto.setCertificationName(entity.getCertificationName());
        return dto;
    }
}