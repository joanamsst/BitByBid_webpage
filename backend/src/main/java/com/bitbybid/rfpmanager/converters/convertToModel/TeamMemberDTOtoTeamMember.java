package com.bitbybid.rfpmanager.converters.convertToModel;

import com.bitbybid.rfpmanager.command.TeamMemberDto;
import com.bitbybid.rfpmanager.model.TeamMember;

public class TeamMemberDTOtoTeamMember {

    public static TeamMember convert(TeamMemberDto dto) {
        TeamMember entity = new TeamMember();
        entity.setId(dto.getId());
        entity.setMemberName(dto.getMemberName());
        entity.setRole(dto.getRole());
        entity.setSpecialization(dto.getSpecialization());
        return entity;
    }
}
