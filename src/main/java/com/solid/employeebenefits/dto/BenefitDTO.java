package com.solid.employeebenefits.dto;

import lombok.Data;

@Data
public class BenefitDTO {
  private Long id;
  private String name;
  private String type;
  private double calculatedAmount;
}