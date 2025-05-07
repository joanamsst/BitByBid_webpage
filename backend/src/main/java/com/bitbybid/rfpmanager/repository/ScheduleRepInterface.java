package com.bitbybid.rfpmanager.repository;

import com.bitbybid.rfpmanager.model.Cronogram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepInterface extends JpaRepository<Cronogram, Long> {

    List<Cronogram> findByRfpFormRequestId(Long requestId);

    List<Cronogram> findByPhaseNameContainingIgnoreCase(String phaseName);

    List<Cronogram> findByStartDateAfter(LocalDate date);
}
