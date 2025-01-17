package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.employee.Employee;
import com.solid.employeebenefits.exception.employee.EmployeeNotFoundException;
import com.solid.employeebenefits.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee getOrCreateEmployee(String employeeId) {
    return employeeRepository.findById(employeeId)
        .orElseGet(() -> {
          Employee newEmployee = new Employee();
          newEmployee.setId(employeeId);
          // Benefits list is initialised in the Employee constructor
          return employeeRepository.save(newEmployee);
        });
  }

  @Override
  public Employee getEmployee(String employeeId) {
    return employeeRepository.findById(employeeId)
        .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
  }
}