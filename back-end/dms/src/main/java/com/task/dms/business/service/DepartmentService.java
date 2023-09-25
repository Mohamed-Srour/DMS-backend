package com.task.dms.business.service;

import java.util.List;

import com.task.dms.business.dto.DepartmentDto;

public interface DepartmentService {
    public void add(DepartmentDto departmentDto);
    public void getDepartmentById(DepartmentDto departmentDto);
}
