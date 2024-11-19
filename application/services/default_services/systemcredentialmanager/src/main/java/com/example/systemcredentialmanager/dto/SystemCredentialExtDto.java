package com.example.systemcredentialmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemCredentialExtDto {

    private String role;
    private List<Object> credentials;
    private String userId;
    private String createdBy;
}
