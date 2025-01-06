package com.solid.employeebenefits.service;

import com.solid.employeebenefits.domain.Benefit;

import java.util.List;

public interface BenefitService {
    List<Benefit> getBenefitsForEmployee(String employeeId);
    void addBenefitToEmployee(String employeeId, Benefit benefit);
}
