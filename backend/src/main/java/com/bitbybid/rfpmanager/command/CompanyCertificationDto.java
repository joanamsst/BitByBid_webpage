package com.bitbybid.rfpmanager.command;

import java.time.LocalDate;

public class CompanyCertificationDto {
    private Long id;
    private String certificationName;
    // Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertificationName() {
        return certificationName;
    }

    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }

}

