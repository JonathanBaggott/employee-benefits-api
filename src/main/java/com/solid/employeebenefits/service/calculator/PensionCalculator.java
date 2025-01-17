package com.solid.employeebenefits.service.calculator;

import com.solid.employeebenefits.domain.BenefitType;
import com.solid.employeebenefits.domain.Pension;
import com.solid.employeebenefits.service.BenefitCalculator;
import org.springframework.stereotype.Service;

@Service
@BenefitType(Pension.class)
public class PensionCalculator implements BenefitCalculator<Pension> {
  @Override
  public double calculateAmount(Pension benefit) {
    return benefit.getBenefitAmount();
  }
}