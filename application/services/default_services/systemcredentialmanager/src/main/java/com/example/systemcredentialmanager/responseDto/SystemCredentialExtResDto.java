package com.example.systemcredentialmanager.responseDto;

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
public class SystemCredentialExtResDto {

    private String role;
    private List<Object> credentials;
    private String userId;
    private String createdDate;
    private String createdBy;
    private String lastModifiedBy;
    private String lastModifiedDate;
}
