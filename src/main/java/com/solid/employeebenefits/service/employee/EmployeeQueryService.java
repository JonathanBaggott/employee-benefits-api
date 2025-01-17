package com.solid.employeebenefits.service.employee;

import com.solid.employeebenefits.domain.employee.Employee;
import com.solid.employeebenefits.exception.employee.EmployeeNotFoundException;
import com.solid.employeebenefits.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeQueryService implements EmployeeReader {
  private final EmployeeRepository employeeRepository;

  public EmployeeQueryService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public Employee getEmployee(String employeeId) {
    return employeeRepository.findById(employeeId)
        .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
  }

  @Override
  @Transactional(readOnly = true)
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public boolean employeeExists(String employeeId) {
    return employeeRepository.existsById(employeeId);
  }
}