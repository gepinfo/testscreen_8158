package com.geppetto.testscreen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hosptitalorders {

@Id
private String id;

private String orderid;

private String orderdate;

private String specimen;

private String patientid;

private String facilityid;

private String episodetype;

private String episodeid;

private String doctor;

private String type;

private String code;

private String pscode;

    
    
}

