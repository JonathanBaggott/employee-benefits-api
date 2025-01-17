package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.Benefit;
import com.solid.employeebenefits.dto.BenefitDTO;
import com.solid.employeebenefits.repository.BenefitRepository;
import com.solid.employeebenefits.service.calculator.BenefitCalculatorFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BenefitQueryService implements BenefitReader {
  private final BenefitRepository repository;
  private final BenefitCalculatorFactory calculatorFactory;

  public BenefitQueryService(
      BenefitRepository repository,
      BenefitCalculatorFactory calculatorFactory) {
    this.repository = repository;
    this.calculatorFactory = calculatorFactory;
  }

  @Override
  @Transactional(readOnly = true)
  public List<BenefitDTO> getBenefitsForEmployee(String employeeId) {
    return repository.findByEmployeeId(employeeId)
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  private BenefitDTO convertToDTO(Benefit benefit) {
    BenefitDTO dto = new BenefitDTO();
    dto.setId(benefit.getId());
    dto.setName(benefit.getName());
    dto.setType(benefit.getClass().getSimpleName());
    dto.setCalculatedAmount(calculatorFactory.getCalculator(benefit).calculateAmount(benefit));
    return dto;
  }
}