package com.task.dms.business.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dms.business.dto.DepartmentDto;
import com.task.dms.business.mappers.DepartmentMapper;
import com.task.dms.business.service.DepartmentService;
import com.task.dms.exceptions.ResourceNotFoundException;
import com.task.dms.presistence.models.Department;
import com.task.dms.presistence.models.Employee;
import com.task.dms.presistence.repositories.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void add(DepartmentDto departmentDto) {
        getDepartmentById(departmentDto);
        departmentRepo.save(departmentMapper.map(departmentDto));
    }

    @Override
    public void getDepartmentById(DepartmentDto departmentDto) {
        Optional<Department> department = departmentRepo.findById(departmentDto.getCode());
        if(department.isEmpty())
        {
            throw new ResourceNotFoundException(departmentDto.getCode());
        }
    }
    
    
}
