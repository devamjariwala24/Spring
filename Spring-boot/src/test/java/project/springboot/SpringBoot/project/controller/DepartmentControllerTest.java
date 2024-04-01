package project.springboot.SpringBoot.project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import project.springboot.SpringBoot.project.entity.Department;
import project.springboot.SpringBoot.project.error.DepartmentNotFoundException;
import project.springboot.SpringBoot.project.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;


    @BeforeEach
    void setUp() {
        department =
                Department.builder().departmentAddress("Ahmedabad").departmentCode("IT-06").departmentID(1L).build();
    }

    @Test
    @DisplayName("Save Department Name in Controllwe")
    void saveDepartment() throws Exception {
        Department inputDepartment =
                Department.builder().departmentAddress("Ahmedabad").departmentCode("IT-06").build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"departmentName\": \"IT\", \"departmentAddress\": \"Ahmedabad\"," +
                                " \"departmentCode\": \"IT-06\" }"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get Department Name by mocking the Controller")
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andExpect(jsonPath("$.departmentName").
                        value(department.getDepartmentName()));
    }
}