package com.task.dms.business.mappers;

import org.mapstruct.Mapper;

import com.task.dms.business.dto.DepartmentDto;
import com.task.dms.presistence.models.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    public Department map(DepartmentDto departmentDto);
    public DepartmentDto map(Department department);
}
