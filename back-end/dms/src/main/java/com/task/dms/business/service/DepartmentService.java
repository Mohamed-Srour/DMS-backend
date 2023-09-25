package com.task.dms.business.service;


import com.task.dms.business.dto.DepartmentDto;

public interface DepartmentService {
    public void add(DepartmentDto departmentDto);
    public DepartmentDto getDepartmentById(DepartmentDto departmentDto);
}
