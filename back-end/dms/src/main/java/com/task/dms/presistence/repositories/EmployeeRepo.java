package com.task.dms.presistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.dms.presistence.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    
}
