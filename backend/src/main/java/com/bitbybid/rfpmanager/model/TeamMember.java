package com.bitbybid.rfpmanager.model;

import jakarta.persistence.*;

@Entity
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private String role;

    @Column(columnDefinition = "TEXT")
    private String specialization;

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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public RfpForm getRfpForm() {
        return rfpForm;
    }

    public void setRfpForm(RfpForm rfpForm) {
        this.rfpForm = rfpForm;
    }
}