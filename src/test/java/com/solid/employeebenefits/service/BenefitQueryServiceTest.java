package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.Pension;
import com.solid.employeebenefits.dto.BenefitDTO;
import com.solid.employeebenefits.repository.BenefitRepository;
import com.solid.employeebenefits.service.calculator.BenefitCalculatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BenefitQueryServiceTest {

  @Mock
  private BenefitRepository benefitRepository;

  @Mock
  private BenefitCalculatorFactory calculatorFactory;

  @InjectMocks
  private BenefitQueryService benefitQueryService;

  private Pension testBenefit;

  @BeforeEach
  void setUp() {
    testBenefit = new Pension();
    testBenefit.setName("Test Pension");
    testBenefit.setBenefitAmount(1000.0);
  }

  @Test
  public void testGetBenefitsForEmployee() {
    // Arrange
    String employeeId = "123";
    when(benefitRepository.findByEmployeeId(employeeId))
        .thenReturn(List.of(testBenefit));
    when(calculatorFactory.getCalculator(any())).thenReturn(benefit -> 1000.0);

    // Act
    List<BenefitDTO> benefits = benefitQueryService.getBenefitsForEmployee(employeeId);

    // Assert
    assertEquals(1, benefits.size());
    assertEquals(1000.0, benefits.get(0).getCalculatedAmount());
    verify(benefitRepository).findByEmployeeId(employeeId);
  }
}