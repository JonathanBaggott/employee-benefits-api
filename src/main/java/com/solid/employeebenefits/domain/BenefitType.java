package com.solid.employeebenefits.domain;

import com.solid.employeebenefits.domain.benefit.Benefit;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BenefitType {
  Class<? extends Benefit> value();
}