package com.task.dms.business.dto;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ResponseDTO {
    String message;
    boolean status;
    Integer code;
    Object data;
    
    

    
}
