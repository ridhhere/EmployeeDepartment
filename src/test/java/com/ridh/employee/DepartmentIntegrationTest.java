package com.ridh.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

public class DepartmentIntegrationTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getDepartment(){
    }
}
