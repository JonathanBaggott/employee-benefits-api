package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.Benefit;
import com.solid.employeebenefits.domain.Employee;
import com.solid.employeebenefits.dto.BenefitCreationDTO;
import com.solid.employeebenefits.factory.BenefitFactory;
import com.solid.employeebenefits.repository.BenefitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BenefitManagementService implements BenefitManager {
  private final BenefitRepository repository;
  private final BenefitFactory factory;
  private final EmployeeService employeeService;

  public BenefitManagementService(
      BenefitRepository repository,
      BenefitFactory factory,
      EmployeeService employeeService) {
    this.repository = repository;
    this.factory = factory;
    this.employeeService = employeeService;
  }

  @Override
  @Transactional
  public void addBenefitToEmployee(String employeeId, BenefitCreationDTO benefitDTO) {
    Employee employee = employeeService.getOrCreateEmployee(employeeId);
    Benefit benefit = factory.createBenefit(benefitDTO);
    benefit.setEmployee(employee);
    repository.save(benefit);
  }
}