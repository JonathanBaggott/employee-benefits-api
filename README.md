# Employee Benefits API

A Spring Boot application that demonstrates the management of employee benefits using SOLID principles.

## Overview
This API provides endpoints to manage different types of employee benefits including pension, health insurance, and life insurance. It allows adding benefits to employees and retrieving all benefits associated with an employee.

## SOLID Principles Implementation

### Single Responsibility Principle (SRP)
- `EmployeeController`: Handles HTTP requests and response formatting
- `BenefitServiceImpl`: Manages employee benefit operations and relationships
- `EmployeeRepository`: Handles data persistence for employees
- Domain classes are focused on their specific benefit types:
    - `Pension`: Handles pension-specific calculations
    - `HealthInsurance`: Manages health insurance specific logic
    - `LifeInsurance`: Contains life insurance related functionality

### Open/Closed Principle (OCP)
The benefit system demonstrates OCP through:
- Abstract `Benefit` class that can be extended for new benefit types
- Current implementations (`Pension`, `HealthInsurance`, `LifeInsurance`) extend base class
- Each benefit type implements its own `calculateBenefitAmount()` method
- New benefit types can be added without modifying existing code

### Liskov Substitution Principle (LSP)
- All benefit types (`Pension`, `HealthInsurance`, `LifeInsurance`) can be used wherever a `Benefit` is expected
- The service layer handles benefits polymorphically
- Each benefit type properly implements the abstract `calculateBenefitAmount()` method

### Interface Segregation Principle (ISP)
- `BenefitService` interface defines only two focused methods:
    - `getBenefitsForEmployee`
    - `addBenefitToEmployee`
- `EmployeeRepository` extends only the necessary `JpaRepository` interface

### Dependency Inversion Principle (DIP)
- `EmployeeController` depends on `BenefitService` interface, not the implementation
- `BenefitServiceImpl` depends on `EmployeeRepository` interface
- Dependencies are injected through constructor injection

## API Endpoints
