package com.solid.employeebenefits.service;

import com.solid.employeebenefits.dto.BenefitCreationDTO;
import com.solid.employeebenefits.dto.BenefitDTO;
import java.util.List;

public interface BenefitService {
    List<BenefitDTO> getBenefitsForEmployee(String employeeId);
    void addBenefitToEmployee(String employeeId, BenefitCreationDTO benefit);
}
