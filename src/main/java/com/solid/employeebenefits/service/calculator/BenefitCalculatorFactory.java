package com.solid.employeebenefits.service.calculator;

import com.solid.employeebenefits.domain.BenefitType;
import com.solid.employeebenefits.domain.benefit.Benefit;
import com.solid.employeebenefits.service.BenefitCalculator;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BenefitCalculatorFactory {
  private final Map<Class<? extends Benefit>, BenefitCalculator<?>> calculators;

  public BenefitCalculatorFactory(List<BenefitCalculator<?>> calculators) {
    this.calculators = calculators.stream()
        .collect(Collectors.toMap(
            calc -> calc.getClass().getAnnotation(BenefitType.class).value(),
            calc -> calc
        ));
  }

  @SuppressWarnings("unchecked")
  public <T extends Benefit> BenefitCalculator<T> getCalculator(T benefit) {
    return (BenefitCalculator<T>) calculators.get(benefit.getClass());
  }
}