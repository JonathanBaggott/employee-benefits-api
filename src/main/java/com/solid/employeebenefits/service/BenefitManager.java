package com.solid.employeebenefits.service;

import com.solid.employeebenefits.dto.BenefitCreationDTO;

public interface BenefitManager {
  void addBenefitToEmployee(String employeeId, BenefitCreationDTO benefit);
}