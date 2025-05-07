package com.bitbybid.rfpmanager.command;

import java.time.LocalDate;
import java.util.List;

public class RfpFormDto {
    private Long requestId;
    private String companyName;
    private LocalDate rfpDate;
    private LocalDate endDate;
    private String projectName;
    private String projectGoal;
    private String technicalDescription;
    private String integrationPlan;
    private String dataSecurity;
    private Double totalPrice;
    private String supportAndWarranty;
    private Boolean wasAccepted;

    private List<CronogramDto> cronogram;

    private List<TeamMemberDto> teamMembers;
    private List<CompanyCertificationDto> companyCertifications;


    // Getters e Setters

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

    public List<CronogramDto> getCronogram() {
        return cronogram;
    }

    public void setCronogram(List<CronogramDto> cronogram) {
        this.cronogram = cronogram;
    }

    public List<TeamMemberDto> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMemberDto> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<CompanyCertificationDto> getCompanyCertifications() {
        return companyCertifications;
    }

    public void setCompanyCertifications(List<CompanyCertificationDto> companyCertifications) {
        this.companyCertifications = companyCertifications;
    }

    public Boolean getWasAccepted() {
        return wasAccepted;
    }

    public void setWasAccepted(Boolean wasAccepted) {
        this.wasAccepted = wasAccepted;
    }
}

