package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.benefit.Benefit;

public interface BenefitCalculator<T extends Benefit> {
  double calculateAmount(T benefit);
}