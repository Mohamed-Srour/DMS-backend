package com.task.dms.business.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.task.dms.presistence.models.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    
     private int code;
     private Department department;
     private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="yyyy-MM-dd" ,  locale ="##defualt"  )
     private Date birthDate;
     private String address;
     private String mobile;
     private Double salary;
}
