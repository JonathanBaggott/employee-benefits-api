package com.solid.employeebenefits.exception.benefit;

public class BenefitNotFoundException extends RuntimeException {
  public BenefitNotFoundException(Long benefitId) {
    super("Benefit not found with id: " + benefitId);
  }
}