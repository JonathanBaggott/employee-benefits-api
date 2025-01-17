package com.solid.employeebenefits.controller;

import com.solid.employeebenefits.dto.BenefitDTO;
import com.solid.employeebenefits.dto.BenefitCreationDTO;
import com.solid.employeebenefits.service.BenefitReader;
import com.solid.employeebenefits.service.BenefitManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BenefitReader benefitReader;

    @MockBean
    private BenefitManager benefitManager;

    @Test
    public void testGetEmployeeBenefits() throws Exception {
        // Arrange
        List<BenefitDTO> benefits = List.of(
            createBenefitDTO("Pension", 1000.0),
            createBenefitDTO("Life Insurance", 500.0)
        );
        when(benefitReader.getBenefitsForEmployee("123")).thenReturn(benefits);

        // Act & Assert
        mockMvc.perform(get("/employees/123/benefits"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].calculatedAmount").value(1000.0))
            .andExpect(jsonPath("$[1].calculatedAmount").value(500.0));
    }

    @Test
    public void testAddBenefit() throws Exception {
        // Arrange
        BenefitCreationDTO benefitDTO = new BenefitCreationDTO();
        benefitDTO.setType("PENSION");
        benefitDTO.setName("Standard Pension");

        // Act & Assert
        mockMvc.perform(post("/employees/123/benefits")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(benefitDTO)))
            .andExpect(status().isOk());
    }

    private BenefitDTO createBenefitDTO(String type, double amount) {
        BenefitDTO dto = new BenefitDTO();
        dto.setType(type);
        dto.setCalculatedAmount(amount);
        return dto;
    }
}