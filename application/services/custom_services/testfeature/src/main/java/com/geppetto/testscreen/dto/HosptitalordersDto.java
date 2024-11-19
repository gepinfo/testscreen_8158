package com.geppetto.testscreen.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Builder;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HosptitalordersDto {

    @NotBlank(message = "id cannot be null or empty")
    private String id;
     
    @NotBlank(message = "orderid cannot be null or empty")  
    private String orderid;
   
    @NotBlank(message = "orderdate cannot be null or empty")  
    private String orderdate;
   
    @NotBlank(message = "specimen cannot be null or empty")  
    private String specimen;
   
    @NotBlank(message = "patientid cannot be null or empty")  
    private String patientid;
   
    @NotBlank(message = "facilityid cannot be null or empty")  
    private String facilityid;
   
    @NotBlank(message = "episodetype cannot be null or empty")  
    private String episodetype;
   
    @NotBlank(message = "episodeid cannot be null or empty")  
    private String episodeid;
   
    @NotBlank(message = "doctor cannot be null or empty")  
    private String doctor;
   
    @NotBlank(message = "type cannot be null or empty")  
    private String type;
   
    @NotBlank(message = "code cannot be null or empty")  
    private String code;
   
    @NotBlank(message = "pscode cannot be null or empty")  
    private String pscode;
  
    }
