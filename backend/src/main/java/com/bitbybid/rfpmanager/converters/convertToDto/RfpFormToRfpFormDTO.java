package com.bitbybid.rfpmanager.converters.convertToDto;

import com.bitbybid.rfpmanager.command.RfpFormDto;
import com.bitbybid.rfpmanager.model.RfpForm;

import java.util.stream.Collectors;

public class RfpFormToRfpFormDTO {

    public static RfpFormDto convert(RfpForm entity) {
        RfpFormDto dto = new RfpFormDto();

        dto.setRequestId(entity.getRequestId());
        dto.setCompanyName(entity.getCompanyName());
        dto.setRfpDate(entity.getRfpDate());
        dto.setEndDate(entity.getEndDate());
        dto.setProjectName(entity.getProjectName());
        dto.setProjectGoal(entity.getProjectGoal());
        dto.setTechnicalDescription(entity.getTechnicalDescription());
        dto.setIntegrationPlan(entity.getIntegrationPlan());
        dto.setDataSecurity(entity.getDataSecurity());
        dto.setTotalPrice(entity.getTotalPrice());
        dto.setSupportAndWarranty(entity.getSupportAndWarranty());
        dto.setWasAccepted(entity.getWasAccepted());


        dto.setCronogram(
                entity.getCronogram().stream()
                        .map(CronogramToCronogramDTO::convert)
                        .collect(Collectors.toList())
        );

        dto.setTeamMembers(
                entity.getTechnicalTeam().stream()
                        .map(TeamMemberToTeamMemberDTO::convert)
                        .collect(Collectors.toList())
        );

        dto.setCompanyCertifications(
                entity.getCompanyCertifications().stream()
                        .map(CompanyCertificationToDto::convert)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
