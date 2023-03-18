package com.ridh.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridh.employee.Service.EmployeeService;
import com.ridh.employee.pojo.DepartmentEntity;
import com.ridh.employee.pojo.EmployeeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasKey;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getEmployee() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employee/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveDepartment() throws Exception {
        // create and save a department entity
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEname("John");
        employee.setEadd("Queens");
        employee.setDno(1L);
        given(employeeService.saveEmployee(employee)).willReturn(employee);

        // perform the POST request and verify the response
        mockMvc.perform(post("/employee/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ename").value("John"))
                .andExpect(jsonPath("$.eadd").value("Queens"))
                .andExpect(jsonPath("$.dno").value(1L));


        // verify that the department was saved
        verify(employeeService, times(1)).saveEmployee(employee);
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
