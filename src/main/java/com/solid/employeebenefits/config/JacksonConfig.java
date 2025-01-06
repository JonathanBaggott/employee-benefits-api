package com.solid.employeebenefits.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.solid.employeebenefits.domain.HealthInsurance;
import com.solid.employeebenefits.domain.LifeInsurance;
import com.solid.employeebenefits.domain.Pension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerSubtypes(
        new NamedType(Pension.class, "PENSION"),
        new NamedType(HealthInsurance.class, "HEALTH"),
        new NamedType(LifeInsurance.class, "LIFE")
    );
    return mapper;
  }
}