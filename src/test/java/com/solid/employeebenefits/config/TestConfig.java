package com.solid.employeebenefits.config;

import com.solid.employeebenefits.repository.EmployeeRepository;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class TestConfig {
    @Bean
    public EmployeeRepository employeeRepository() {
        return Mockito.mock(EmployeeRepository.class);
    }
}