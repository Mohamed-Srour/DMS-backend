package com.task.dms.business.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.task.dms.presistence.models.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class EmployeeDto {
    
     private Integer code;
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
     private Department department;
     private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING ,pattern="yyyy-MM-dd" ,  locale ="##defualt"  )
     private Date birth_date;
     private String address;
     private String mobile;
     private Double salary;
}
