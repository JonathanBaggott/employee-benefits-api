package com.solid.employeebenefits.controller;

import com.solid.employeebenefits.domain.Benefit;
import com.solid.employeebenefits.service.BenefitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final BenefitService benefitService;

    public EmployeeController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @GetMapping("/{employeeId}/benefits")
    public ResponseEntity<List<Benefit>> getEmployeeBenefits(@PathVariable String employeeId) {
        List<Benefit> benefits = benefitService.getBenefitsForEmployee(employeeId);
        return ResponseEntity.ok(benefits);
    }

    @PostMapping("/{employeeId}/benefits")
    public ResponseEntity<Void> addEmployeeBenefit(
        @PathVariable String employeeId,
        @RequestBody Benefit benefit) {
        benefitService.addBenefitToEmployee(employeeId, benefit);
        return ResponseEntity.ok().build();
    }
}
