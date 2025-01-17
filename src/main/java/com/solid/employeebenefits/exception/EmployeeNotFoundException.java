package com.solid.employeebenefits.exception;

public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException(String employeeId) {
    super("Employee not found with id: " + employeeId);
  }
}