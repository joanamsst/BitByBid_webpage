package com.bitbybid.rfpmanager.converters.convertToDto;

import com.bitbybid.rfpmanager.command.TeamMemberDto;
import com.bitbybid.rfpmanager.model.TeamMember;

public class TeamMemberToTeamMemberDTO {

    public static TeamMemberDto convert(TeamMember entity) {
        TeamMemberDto dto = new TeamMemberDto();
        dto.setId(entity.getId());
        dto.setMemberName(entity.getMemberName());
        dto.setRole(entity.getRole());
        dto.setSpecialization(entity.getSpecialization());
        return dto;
    }
}
