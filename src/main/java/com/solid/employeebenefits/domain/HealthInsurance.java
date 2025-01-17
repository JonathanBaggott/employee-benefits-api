package com.solid.employeebenefits.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HEALTH")
public class HealthInsurance extends Benefit {
    private double monthlyPremium;

    @Override
    public double calculateBenefitAmount() {
        // Calculate health insurance benefit (e.g., reimbursement)
        return monthlyPremium * 12 * 0.8;
    }

    public double getMonthlyPremium() {
        return monthlyPremium;
    }

    public void setMonthlyPremium(double monthlyPremium) {
        this.monthlyPremium = monthlyPremium;
    }
}