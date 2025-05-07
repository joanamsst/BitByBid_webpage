package com.bitbybid.rfpmanager.converters.convertToModel;

import com.bitbybid.rfpmanager.command.CompanyCertificationDto;
import com.bitbybid.rfpmanager.model.CompanyCertification;

public class CompanyCertificationDtoToEntity {

    public static CompanyCertification convert(CompanyCertificationDto dto) {
        CompanyCertification entity = new CompanyCertification();
        entity.setId(dto.getId());
        entity.setCertificationName(dto.getCertificationName());
        return entity;
    }
}
