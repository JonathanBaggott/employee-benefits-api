package com.solid.employeebenefits.domain.benefit;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("PENSION")
public class Pension extends Benefit {
    private double benefitAmount;

    @Override
    public double calculateBenefitAmount() {
        return benefitAmount;
    }

    public double getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(double benefitAmount) {
        this.benefitAmount = benefitAmount;
    }
}