package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.employee.Employee;

public interface EmployeeService {
  Employee getOrCreateEmployee(String employeeId);
  Employee getEmployee(String employeeId);
}