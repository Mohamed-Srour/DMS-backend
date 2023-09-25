package com.task.dms.business.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.task.dms.business.dto.EmployeeDto;
import com.task.dms.presistence.models.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    public Employee map(EmployeeDto employeeDto);
    public EmployeeDto map(Employee employee);
    public List<EmployeeDto> map(List<Employee> employees);

    
}
