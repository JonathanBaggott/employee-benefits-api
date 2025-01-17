package com.solid.employeebenefits.factory;

import com.solid.employeebenefits.domain.Benefit;
import com.solid.employeebenefits.domain.HealthInsurance;
import com.solid.employeebenefits.domain.LifeInsurance;
import com.solid.employeebenefits.domain.Pension;
import com.solid.employeebenefits.dto.BenefitCreationDTO;
import org.springframework.stereotype.Component;

@Component
public class BenefitFactory {
  public Benefit createBenefit(BenefitCreationDTO dto) {
    return switch (dto.getType()) {
      case "PENSION" -> createPension(dto);
      case "HEALTH" -> createHealthInsurance(dto);
      case "LIFE" -> createLifeInsurance(dto);
      default -> throw new IllegalArgumentException("Unknown benefit type: " + dto.getType());
    };
  }

  private Pension createPension(BenefitCreationDTO dto) {
    Pension pension = new Pension();
    pension.setName(dto.getName());
    pension.setBenefitAmount((Double) dto.getParameters().get("benefitAmount"));
    return pension;
  }

  private HealthInsurance createHealthInsurance(BenefitCreationDTO dto) {
    HealthInsurance healthInsurance = new HealthInsurance();
    healthInsurance.setName(dto.getName());
    healthInsurance.setMonthlyPremium((Double) dto.getParameters().get("monthlyPremium"));
    return healthInsurance;
  }

  private LifeInsurance createLifeInsurance(BenefitCreationDTO dto) {
    LifeInsurance lifeInsurance = new LifeInsurance();
    lifeInsurance.setName(dto.getName());
    lifeInsurance.setCoverageAmount((Double) dto.getParameters().get("coverageAmount"));
    return lifeInsurance;
  }
}