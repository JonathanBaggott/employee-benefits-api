package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.Benefit;
import com.solid.employeebenefits.domain.Employee;
import com.solid.employeebenefits.repository.EmployeeRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class BenefitServiceImpl implements BenefitService {

    private final EmployeeRepository employeeRepository;

    public BenefitServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Benefit> getBenefitsForEmployee(String employeeId) {
        return employeeRepository.findById(employeeId)
            .map(Employee::getBenefits)
            .orElse(Collections.emptyList());
    }

    @Override
    @Transactional
    public void addBenefitToEmployee(String employeeId, Benefit benefit) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseGet(() -> {
                Employee newEmployee = new Employee();
                newEmployee.setId(employeeId);
                newEmployee.setBenefits(new ArrayList<>());
                return newEmployee;
            });

        benefit.setEmployee(employee);
        employee.getBenefits().add(benefit);
        employeeRepository.save(employee);
    }
}