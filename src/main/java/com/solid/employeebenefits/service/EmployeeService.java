package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.Employee;

public interface EmployeeService {
  Employee getOrCreateEmployee(String employeeId);
  Employee getEmployee(String employeeId);
}