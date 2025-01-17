package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.employee.Employee;
import com.solid.employeebenefits.domain.benefit.Pension;
import com.solid.employeebenefits.dto.BenefitCreationDTO;
import com.solid.employeebenefits.factory.BenefitFactory;
import com.solid.employeebenefits.repository.benefit.BenefitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BenefitManagementServiceTest {

  @Mock
  private BenefitRepository benefitRepository;

  @Mock
  private EmployeeService employeeService;

  @Mock
  private BenefitFactory benefitFactory;

  @InjectMocks
  private BenefitManagementService benefitManagementService;

  private Pension testBenefit;

  @BeforeEach
  void setUp() {
    testBenefit = new Pension();
    testBenefit.setName("Test Pension");
    testBenefit.setBenefitAmount(1000.0);
  }

  @Test
  public void testAddBenefitToEmployee() {
    // Arrange
    String employeeId = "123";
    Employee employee = new Employee(employeeId, "Test Employee");

    BenefitCreationDTO benefitDTO = new BenefitCreationDTO();
    benefitDTO.setType("PENSION");
    benefitDTO.setName("Standard Pension");
    benefitDTO.setParameters(Map.of("benefitAmount", 1000.0));

    Pension testPension = new Pension();
    when(employeeService.getOrCreateEmployee(employeeId)).thenReturn(employee);
    when(benefitFactory.createBenefit(benefitDTO)).thenReturn(testPension);

    // Act
    benefitManagementService.addBenefitToEmployee(employeeId, benefitDTO);

    // Assert
    verify(benefitRepository, times(1)).save(any());
  }
}