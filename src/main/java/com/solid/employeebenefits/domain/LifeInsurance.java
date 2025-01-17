package com.solid.employeebenefits.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LIFE")
public class LifeInsurance extends Benefit {
    private double coverageAmount;

    @Override
    public double calculateBenefitAmount() {
        // Calculate life insurance amount based on coverage
        return coverageAmount * 0.01;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }
}