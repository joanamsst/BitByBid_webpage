package com.bitbybid.rfpmanager.converters.convertToModel;

import com.bitbybid.rfpmanager.command.CronogramDto;
import com.bitbybid.rfpmanager.model.Cronogram;

public class CronogramDTOToCronogram {

    public static Cronogram convert(CronogramDto dto) {
        Cronogram entity = new Cronogram();

        entity.setId(dto.getId());
        entity.setPhaseName(dto.getPhaseName());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setDeliverables(dto.getDeliverables());

        return entity;
    }
}
