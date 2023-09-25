package com.task.dms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dms.business.dto.EmployeeDto;
import com.task.dms.business.dto.ResponseDTO;
import com.task.dms.business.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseDTO save(@RequestBody EmployeeDto employeeDto)
    {
        employeeService.add(employeeDto);
        return new ResponseDTO("employee added", true, 200, employeeDto);
    }

    @GetMapping("/getAll")
    public ResponseDTO getAll()
    {
        return new ResponseDTO("all employees", true, 200, employeeService.getAll());
    }
    @PostMapping("/search")
    public ResponseDTO search(@RequestBody EmployeeDto employeeDto)
    {
        return new ResponseDTO("employees searched for", true, 200, employeeService.searchEmployee(employeeDto));
    }
}
