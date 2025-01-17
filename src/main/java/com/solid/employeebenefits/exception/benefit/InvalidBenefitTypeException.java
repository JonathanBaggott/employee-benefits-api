package com.solid.employeebenefits.exception.benefit;

public class InvalidBenefitTypeException extends RuntimeException {
  public InvalidBenefitTypeException(String type) {
    super("Invalid benefit type: " + type);
  }
}