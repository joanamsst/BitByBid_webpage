package com.bitbybid.rfpmanager.converters.convertToModel;

import com.bitbybid.rfpmanager.command.RfpFormDto;
import com.bitbybid.rfpmanager.model.RfpForm;

import java.util.stream.Collectors;

public class RfpFormDTOToRfpForm {
    public static RfpForm convert(RfpFormDto dto) {
        RfpForm entity = new RfpForm();
        entity.setRequestId(dto.getRequestId());
        entity.setCompanyName(dto.getCompanyName());
        entity.setRfpDate(dto.getRfpDate());
        entity.setEndDate(dto.getEndDate());
        entity.setProjectName(dto.getProjectName());
        entity.setProjectGoal(dto.getProjectGoal());
        entity.setTechnicalDescription(dto.getTechnicalDescription());
        entity.setIntegrationPlan(dto.getIntegrationPlan());
        entity.setDataSecurity(dto.getDataSecurity());
        entity.setTotalPrice(dto.getTotalPrice());
        entity.setSupportAndWarranty(dto.getSupportAndWarranty());
        entity.setWasAccepted(dto.getWasAccepted());

        // Set Cronogram + link parent
        var cronogramList = dto.getCronogram().stream()
                .map(CronogramDTOToCronogram::convert)
                .peek(c -> c.setRfpForm(entity))
                .collect(Collectors.toList());
        entity.setCronogram(cronogramList);
        // Set Team + link parent
        var teamList = dto.getTeamMembers().stream()
                .map(TeamMemberDTOtoTeamMember::convert)
                .peek(t -> t.setRfpForm(entity))
                .collect(Collectors.toList());
        entity.setTechnicalTeam(teamList);
        // Set Certifications + link parent
        var certList = dto.getCompanyCertifications().stream()
                .map(CompanyCertificationDtoToEntity::convert)
                .peek(c -> c.setRfpForm(entity))
                .collect(Collectors.toList());
        entity.setCompanyCertifications(certList);
        return entity;
    }
}