package com.bitbybid.rfpmanager.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Cronogram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phaseName;
    private LocalDate startDate;
    private LocalDate endDate;

    @Column(columnDefinition = "TEXT")
    private String deliverables;

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

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDeliverables() {
        return deliverables;
    }

    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }

    public RfpForm getRfpForm() {
        return rfpForm;
    }

    public void setRfpForm(RfpForm rfpForm) {
        this.rfpForm = rfpForm;
    }
}
