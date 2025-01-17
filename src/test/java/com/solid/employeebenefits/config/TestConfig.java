package com.solid.employeebenefits.config;

import com.solid.employeebenefits.repository.EmployeeRepository;
import com.solid.employeebenefits.repository.BenefitRepository;
import com.solid.employeebenefits.service.calculator.BenefitCalculatorFactory;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class TestConfig {
    @Bean
    public EmployeeRepository employeeRepository() {
        return Mockito.mock(EmployeeRepository.class);
    }

    @Bean
    public BenefitRepository benefitRepository() {
        return Mockito.mock(BenefitRepository.class);
    }

    @Bean
    public BenefitCalculatorFactory benefitCalculatorFactory() {
        return Mockito.mock(BenefitCalculatorFactory.class);
    }
}