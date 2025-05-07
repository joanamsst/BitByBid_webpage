package com.bitbybid.rfpmanager.converters.convertToDto;

import com.bitbybid.rfpmanager.command.CronogramDto;
import com.bitbybid.rfpmanager.model.Cronogram;

public class CronogramToCronogramDTO {

    public static CronogramDto convert(Cronogram entity) {
        CronogramDto dto = new CronogramDto();

        dto.setId(entity.getId());
        dto.setPhaseName(entity.getPhaseName());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setDeliverables(entity.getDeliverables());

        return dto;
    }
}
