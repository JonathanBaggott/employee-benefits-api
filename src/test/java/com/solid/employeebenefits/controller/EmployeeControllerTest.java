package com.solid.employeebenefits.controller;

import com.solid.employeebenefits.controller.EmployeeController;
import com.solid.employeebenefits.domain.Benefit;
import com.solid.employeebenefits.domain.LifeInsurance;
import com.solid.employeebenefits.domain.Pension;
import com.solid.employeebenefits.service.BenefitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BenefitService benefitService;

    @Test
    public void testGetEmployeeBenefits() throws Exception {
        // Arrange
        List<Benefit> benefits = List.of(new Pension(), new LifeInsurance());
        when(benefitService.getBenefitsForEmployee("123")).thenReturn(benefits);

        // Act & Assert
        mockMvc.perform(get("/employees/123/benefits"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }
}