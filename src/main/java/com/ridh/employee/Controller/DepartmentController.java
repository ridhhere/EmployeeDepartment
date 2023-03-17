package com.ridh.employee.Controller;

import com.ridh.employee.Service.DepartmentService;
import com.ridh.employee.Service.EmployeeService;
import com.ridh.employee.pojo.DepartmentEntity;
import com.ridh.employee.pojo.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/add")
	public DepartmentEntity saveEmployee(@RequestBody DepartmentEntity employee) {
		return departmentService.saveDepartment(employee);
	}

	@GetMapping("/all")
	public List<DepartmentEntity> findAllEmployee() {
		return departmentService.findAllDepartment();
	}

}
