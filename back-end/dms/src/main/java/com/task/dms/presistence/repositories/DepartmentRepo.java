package com.task.dms.presistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.dms.presistence.models.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer>{
    
}
