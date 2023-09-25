package com.task.dms.business.service;

import java.util.List;

import com.task.dms.business.dto.EmployeeDto;
import com.task.dms.presistence.models.Employee;

public interface EmployeeService {
    public void add(EmployeeDto employeeDto);
    public List<EmployeeDto> getAll();
    public List<EmployeeDto> searchEmployee(EmployeeDto employeeDto);
    public Employee getEmployeeById(EmployeeDto employeeDto);
}
