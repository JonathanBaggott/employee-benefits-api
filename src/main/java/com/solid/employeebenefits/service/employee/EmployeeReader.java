package com.solid.employeebenefits.service.employee;

import com.solid.employeebenefits.domain.employee.Employee;
import java.util.List;

public interface EmployeeReader {
  Employee getEmployee(String employeeId);
  List<Employee> getAllEmployees();
  boolean employeeExists(String employeeId);
}