package com.task.dms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dms.business.dto.DepartmentDto;
import com.task.dms.business.dto.ResponseDTO;
import com.task.dms.business.service.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin("http://localhost:4200")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseDTO saveDepartment(@RequestBody DepartmentDto departmentDto)
    {
        departmentService.add(departmentDto);
        return new ResponseDTO("Department added", true, 200, departmentDto);
    }
}
