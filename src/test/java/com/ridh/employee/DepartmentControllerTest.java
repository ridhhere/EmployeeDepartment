package com.ridh.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridh.employee.Service.DepartmentService;
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

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    public void getAllDepartment() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/department/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveDepartment() throws Exception {
        // create and save a department entity
        DepartmentEntity department = new DepartmentEntity();
        department.setDname("IT");
        department.setLoc("New York");
        Set<EmployeeEntity> employees = new HashSet<>();
        employees.add(new EmployeeEntity(null,"John", "Manhattan",null));
        department.setEmployee(employees);
        given(departmentService.saveDepartment(department)).willReturn(department);

        // perform the POST request and verify the response
        mockMvc.perform(post("/department/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(department)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dname").value("IT"))
                .andExpect(jsonPath("$.loc").value("New York"))
                .andExpect(jsonPath("$").value(hasKey("employee")))
                .andExpect(jsonPath("$.employee[0].ename").value("John"))
                .andExpect(jsonPath("$.employee[0].eadd").value("Manhattan"));

        // verify that the department was saved
        verify(departmentService, times(1)).saveDepartment(department);
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
