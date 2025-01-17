package com.solid.employeebenefits.service.calculator;

import com.solid.employeebenefits.domain.BenefitType;
import com.solid.employeebenefits.domain.benefit.LifeInsurance;
import com.solid.employeebenefits.service.BenefitCalculator;
import org.springframework.stereotype.Service;

@Service
@BenefitType(LifeInsurance.class)
public class LifeInsuranceCalculator implements BenefitCalculator<LifeInsurance> {
  @Override
  public double calculateAmount(LifeInsurance benefit) {
    return benefit.getCoverageAmount() * 0.01;
  }
}