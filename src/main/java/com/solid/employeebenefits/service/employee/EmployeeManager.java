package com.solid.employeebenefits.service.employee;

import com.solid.employeebenefits.domain.employee.Employee;

public interface EmployeeManager {
  Employee createEmployee(String employeeId, String name);
  Employee getOrCreateEmployee(String employeeId);
  void deleteEmployee(String employeeId);
  Employee updateEmployee(String employeeId, String name);
}