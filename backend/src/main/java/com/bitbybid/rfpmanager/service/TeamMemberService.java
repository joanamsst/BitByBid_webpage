package com.bitbybid.rfpmanager.service;

import com.bitbybid.rfpmanager.command.TeamMemberDto;
import com.bitbybid.rfpmanager.converters.convertToDto.TeamMemberToTeamMemberDTO;
import com.bitbybid.rfpmanager.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberRepository repository;

    public List<TeamMemberDto> getTeamByRfpId(Long rfpId) {
        return repository.findByRfpFormRequestId(rfpId)
                .stream()
                .map(TeamMemberToTeamMemberDTO::convert)
                .collect(Collectors.toList());
    }
}
