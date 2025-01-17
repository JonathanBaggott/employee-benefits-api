package com.solid.employeebenefits.controller;

import com.solid.employeebenefits.dto.BenefitDTO;
import com.solid.employeebenefits.dto.BenefitCreationDTO;
import com.solid.employeebenefits.service.BenefitReader;
import com.solid.employeebenefits.service.BenefitManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final BenefitReader benefitReader;
    private final BenefitManager benefitManager;

    public EmployeeController(BenefitReader benefitReader, BenefitManager benefitManager) {
        this.benefitReader = benefitReader;
        this.benefitManager = benefitManager;
    }

    @GetMapping("/{employeeId}/benefits")
    public ResponseEntity<List<BenefitDTO>> getEmployeeBenefits(@PathVariable String employeeId) {
        List<BenefitDTO> benefits = benefitReader.getBenefitsForEmployee(employeeId);
        return ResponseEntity.ok(benefits);
    }

    @PostMapping("/{employeeId}/benefits")
    public ResponseEntity<Void> addEmployeeBenefit(
        @PathVariable String employeeId,
        @RequestBody BenefitCreationDTO benefit) {
        benefitManager.addBenefitToEmployee(employeeId, benefit);
        return ResponseEntity.ok().build();
    }
}