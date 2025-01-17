package com.solid.employeebenefits.service.employee;

import com.solid.employeebenefits.domain.employee.Employee;
import com.solid.employeebenefits.exception.employee.EmployeeNotFoundException;
import com.solid.employeebenefits.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeManagementService implements EmployeeManager {
  private final EmployeeRepository employeeRepository;

  public EmployeeManagementService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  @Transactional
  public Employee createEmployee(String employeeId, String name) {
    Employee employee = new Employee(employeeId, name);
    return employeeRepository.save(employee);
  }

  @Override
  @Transactional
  public Employee getOrCreateEmployee(String employeeId) {
    return employeeRepository.findById(employeeId)
        .orElseGet(() -> createEmployee(employeeId, null));
  }

  @Override
  @Transactional
  public void deleteEmployee(String employeeId) {
    if (!employeeRepository.existsById(employeeId)) {
      throw new EmployeeNotFoundException(employeeId);
    }
    employeeRepository.deleteById(employeeId);
  }

  @Override
  @Transactional
  public Employee updateEmployee(String employeeId, String name) {
    Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    employee.setName(name);
    return employeeRepository.save(employee);
  }
}