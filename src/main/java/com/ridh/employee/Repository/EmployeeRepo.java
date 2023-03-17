package com.ridh.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridh.employee.pojo.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long>{

}
