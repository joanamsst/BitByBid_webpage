package com.bitbybid.rfpmanager.model;

import jakarta.persistence.*;

@Entity
public class CompanyCertification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String certificationName;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private RfpForm rfpForm;

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

    public RfpForm getRfpForm() {
        return rfpForm;
    }

    public void setRfpForm(RfpForm rfpForm) {
        this.rfpForm = rfpForm;
    }
}
