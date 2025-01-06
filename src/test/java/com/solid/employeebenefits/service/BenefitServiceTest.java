package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.*;
import com.solid.employeebenefits.repository.EmployeeRepository;
import com.solid.employeebenefits.service.BenefitServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BenefitServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private BenefitServiceImpl benefitService;

    @Test
    public void testAddBenefitToEmployee() {
        // Arrange: Mock employee
        Employee employee = new Employee();
        employee.setId("123");
        employee.setBenefits(new ArrayList<>());
        when(employeeRepository.findById("123")).thenReturn(Optional.of(employee));

        // Act
        HealthInsurance healthInsurance = new HealthInsurance();
        benefitService.addBenefitToEmployee("123", healthInsurance);

        // Assert
        verify(employeeRepository, times(1)).save(argThat(e -> e.getBenefits().contains(healthInsurance)));
    }

    @Test
    public void testGetBenefitsForEmployee() {
        // Arrange: Mock employee with benefits
        Employee employee = new Employee();
        employee.setId("123");
        employee.setBenefits(List.of(new Pension(), new LifeInsurance()));
        when(employeeRepository.findById("123")).thenReturn(Optional.of(employee));

        // Act
        List<Benefit> benefits = benefitService.getBenefitsForEmployee("123");

        // Assert
        assertThat(benefits, containsInAnyOrder(instanceOf(Pension.class), instanceOf(LifeInsurance.class)));
    }

}