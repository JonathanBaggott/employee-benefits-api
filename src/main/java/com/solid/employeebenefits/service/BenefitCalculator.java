package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.Benefit;

public interface BenefitCalculator<T extends Benefit> {
  double calculateAmount(T benefit);
}