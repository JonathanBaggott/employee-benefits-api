package com.solid.employeebenefits.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Employee {
    @Id
    private String id;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private final List<Benefit> benefits = new ArrayList<>();

    public Employee() {
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Benefit> getBenefits() {
        return Collections.unmodifiableList(benefits);
    }

    public void addBenefit(Benefit benefit) {
        benefits.add(benefit);
        benefit.setEmployee(this);
    }
}