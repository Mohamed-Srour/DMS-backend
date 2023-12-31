package com.task.dms.business.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dms.business.dto.DepartmentDto;
import com.task.dms.business.dto.EmployeeDto;
import com.task.dms.business.mappers.DepartmentMapper;
import com.task.dms.business.mappers.EmployeeMapper;
import com.task.dms.business.service.DepartmentService;
import com.task.dms.business.service.EmployeeService;
import com.task.dms.exceptions.DuplicatedExceptions;
import com.task.dms.exceptions.ResourceNotFoundException;
import com.task.dms.presistence.models.Employee;
import com.task.dms.presistence.repositories.EmployeeRepo;
import com.task.dms.presistence.repositories.SearchReop;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private SearchReop searchReop;
    @Override
    public void add(EmployeeDto employeeDto) {
        Employee employee = getEmployeeById(employeeDto);
        if (employee != null) {
            throw new DuplicatedExceptions(employeeDto.getCode());
        }
        DepartmentDto departmentDto = departmentService
                .getDepartmentById(employeeDto.getDepartment());
        if (departmentDto == null) {
            throw new ResourceNotFoundException(employeeDto.getDepartment().getCode());
        }
        java.util.Date birthDate = employeeDto.getBirth_date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        java.util.Date dateOnly = new java.sql.Date(calendar.getTimeInMillis());
        employeeDto.setBirth_date(dateOnly);
        employeeRepo.save(employeeMapper.map(employeeDto));
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employee = employeeRepo.findAll();
        for (Employee i : employee) {
            System.out.println(i.getBirth_date());
        }

        return employeeMapper.map(employeeRepo.findAll());
    }

    @Override
    public List<EmployeeDto> searchEmployee(EmployeeDto employeeDto) {
        List<EmployeeDto> employeeDtos=employeeMapper.map(searchReop.employeefilter(employeeDto));
        return employeeDtos;
    }

    @Override
    public Employee getEmployeeById(EmployeeDto employeeDto) {
        Optional<Employee> employee = employeeRepo.findById(employeeMapper.map(employeeDto).getCode());
        return employee.orElse(null);
    }

}
