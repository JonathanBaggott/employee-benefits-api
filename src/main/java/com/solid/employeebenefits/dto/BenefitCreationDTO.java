package com.solid.employeebenefits.dto;

import lombok.Data;
import java.util.Map;

@Data
public class BenefitCreationDTO {
  private String type;
  private String name;
  private Map<String, Object> parameters;
}