package com.solid.employeebenefits.service;

import com.solid.employeebenefits.dto.BenefitDTO;
import java.util.List;

public interface BenefitReader {
  List<BenefitDTO> getBenefitsForEmployee(String employeeId);
}