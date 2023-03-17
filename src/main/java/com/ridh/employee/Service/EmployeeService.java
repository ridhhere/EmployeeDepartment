package com.ridh.employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridh.employee.Repository.EmployeeRepo;
import com.ridh.employee.pojo.EmployeeEntity;


@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepo employeeRepo;
	public EmployeeEntity saveEmployee(EmployeeEntity employee){
        return employeeRepo.save(employee);
    }

    public List<EmployeeEntity> findAllEmployee() {
        return employeeRepo.findAll();
    }

    public EmployeeEntity findEmployee(Long employeeId) {
        return employeeRepo.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Employee ID: " + employeeId));
    }

}
