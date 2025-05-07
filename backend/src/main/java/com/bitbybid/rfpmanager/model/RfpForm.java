package com.bitbybid.rfpmanager.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class RfpForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private String companyName;
    private LocalDate rfpDate;
    private LocalDate endDate;
    private String projectName;

    @Column(columnDefinition = "TEXT")
    private String projectGoal;

    @Column(columnDefinition = "TEXT")
    private String technicalDescription;

    @Column(columnDefinition = "TEXT")
    private String integrationPlan;

    @Column(columnDefinition = "TEXT")
    private String dataSecurity;

    private Double totalPrice;

    @Column(columnDefinition = "TEXT")
    private String supportAndWarranty;

    @Column
    private Boolean wasAccepted;

    @OneToMany(mappedBy = "rfpForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cronogram> cronogram;

    @OneToMany(mappedBy = "rfpForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyCertification> companyCertifications;

    @OneToMany(mappedBy = "rfpForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMember> technicalTeam;



    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getRfpDate() {
        return rfpDate;
    }

    public void setRfpDate(LocalDate rfpDate) {
        this.rfpDate = rfpDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectGoal() {
        return projectGoal;
    }

    public void setProjectGoal(String projectGoal) {
        this.projectGoal = projectGoal;
    }

    public String getTechnicalDescription() {
        return technicalDescription;
    }

    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public String getIntegrationPlan() {
        return integrationPlan;
    }

    public void setIntegrationPlan(String integrationPlan) {
        this.integrationPlan = integrationPlan;
    }

    public String getDataSecurity() {
        return dataSecurity;
    }

    public void setDataSecurity(String dataSecurity) {
        this.dataSecurity = dataSecurity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSupportAndWarranty() {
        return supportAndWarranty;
    }

    public void setSupportAndWarranty(String supportAndWarranty) {
        this.supportAndWarranty = supportAndWarranty;
    }

    public List<Cronogram> getCronogram() {
        return cronogram;
    }

    public void setCronogram(List<Cronogram> cronogram) {
        this.cronogram = cronogram;
    }

    public List<CompanyCertification> getCompanyCertifications() {
        return companyCertifications;
    }

    public void setCompanyCertifications(List<CompanyCertification> companyCertifications) {
        this.companyCertifications = companyCertifications;
    }

    public List<TeamMember> getTechnicalTeam() {
        return technicalTeam;
    }

    public void setTechnicalTeam(List<TeamMember> technicalTeam) {
        this.technicalTeam = technicalTeam;
    }

    public Boolean getWasAccepted() {
        return wasAccepted;
    }

    public void setWasAccepted(Boolean wasAccepted) {
        this.wasAccepted = wasAccepted;
    }
}

