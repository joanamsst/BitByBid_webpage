package com.bitbybid.rfpmanager.repository;


import com.bitbybid.rfpmanager.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    // Get all team members linked to an RFP
    List<TeamMember> findByRfpFormRequestId(Long requestId);

}