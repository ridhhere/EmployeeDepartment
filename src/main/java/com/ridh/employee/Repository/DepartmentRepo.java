package com.ridh.employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ridh.employee.pojo.DepartmentEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity,Long>{

}
