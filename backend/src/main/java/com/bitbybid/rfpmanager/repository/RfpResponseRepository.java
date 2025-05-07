package com.bitbybid.rfpmanager.repository;
import com.bitbybid.rfpmanager.model.RfpForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RfpResponseRepository extends JpaRepository<RfpForm, Long> {

    List<RfpForm> findByCompanyName(String companyName);

    List<RfpForm>  findByRfpDate(LocalDate rfpDate);

    List<RfpForm>  findByEndDateAfter(LocalDate endDate);

    List<RfpForm>  findByProjectName(String projectName);

    List<RfpForm>  findByProjectGoalContainingIgnoreCase(String keyword);

    List<RfpForm>  findByTotalPriceGreaterThan(Double price);

    List<RfpForm>  findByTotalPriceBetween(Double min, Double max);

    @Query("SELECT r FROM RfpForm r WHERE " +
            "LOWER(r.projectName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(r.companyName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(r.projectGoal) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<RfpForm> findByKeyword(@Param("keyword") String keyword);

}