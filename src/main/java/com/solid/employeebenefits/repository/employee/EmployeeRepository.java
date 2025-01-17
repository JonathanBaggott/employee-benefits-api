package com.solid.employeebenefits.repository.employee;

import com.solid.employeebenefits.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}