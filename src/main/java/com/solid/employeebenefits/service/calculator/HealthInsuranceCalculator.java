package com.solid.employeebenefits.service.calculator;

import com.solid.employeebenefits.domain.BenefitType;
import com.solid.employeebenefits.domain.HealthInsurance;
import com.solid.employeebenefits.service.BenefitCalculator;
import org.springframework.stereotype.Service;

@Service
@BenefitType(HealthInsurance.class)
public class HealthInsuranceCalculator implements BenefitCalculator<HealthInsurance> {
  @Override
  public double calculateAmount(HealthInsurance benefit) {
    return benefit.getMonthlyPremium() * 12 * 0.8;
  }
}