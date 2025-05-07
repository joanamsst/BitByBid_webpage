package com.bitbybid.rfpmanager.controller;

import com.bitbybid.rfpmanager.command.TeamMemberDto;
import com.bitbybid.rfpmanager.converters.convertToModel.TeamMemberDTOtoTeamMember;
import com.bitbybid.rfpmanager.converters.convertToDto.TeamMemberToTeamMemberDTO;
import com.bitbybid.rfpmanager.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/team-members")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamMemberController {

    @Autowired
    private TeamMemberRepository repository;

    @GetMapping
    public List<TeamMemberDto> getAll() {
        return repository.findAll().stream()
                .map(TeamMemberToTeamMemberDTO::convert)
                .collect(Collectors.toList());
    }

    @PostMapping
    public TeamMemberDto create(@RequestBody TeamMemberDto dto) {
        return TeamMemberToTeamMemberDTO.convert(
                repository.save(TeamMemberDTOtoTeamMember.convert(dto))
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
