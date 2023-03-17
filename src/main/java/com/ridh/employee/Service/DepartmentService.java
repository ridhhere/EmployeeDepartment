package com.ridh.employee.Service;

import com.ridh.employee.Repository.DepartmentRepo;
import com.ridh.employee.Repository.EmployeeRepo;
import com.ridh.employee.pojo.DepartmentEntity;
import com.ridh.employee.pojo.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentService {
	@Autowired
    private DepartmentRepo departmentRepo;
	public DepartmentEntity saveDepartment(DepartmentEntity department){
        return departmentRepo.save(department);
    }

    public List<DepartmentEntity> findAllDepartment() {
        return departmentRepo.findAll();
    }


}
