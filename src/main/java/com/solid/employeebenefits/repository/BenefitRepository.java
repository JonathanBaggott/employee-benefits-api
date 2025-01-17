package com.solid.employeebenefits.repository;

import com.solid.employeebenefits.domain.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BenefitRepository extends JpaRepository<Benefit, Long> {
  List<Benefit> findByEmployeeId(String employeeId);
}