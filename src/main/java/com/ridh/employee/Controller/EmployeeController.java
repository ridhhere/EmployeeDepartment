package com.ridh.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ridh.employee.Service.EmployeeService;
import com.ridh.employee.pojo.EmployeeEntity;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/all")
	public List<EmployeeEntity> findAllEmployee() {
		return employeeService.findAllEmployee();
	}

	@GetMapping("/id/{employeeId}")
	public EmployeeEntity findEmployee(@PathVariable Long employeeId) {
		return employeeService.findEmployee(employeeId);
	}

}
