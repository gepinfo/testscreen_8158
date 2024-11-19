package com.example.systemcredentialmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "systemCredentialsExternalManager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemCredentialsExternalManager {

    @Id
    private String id;
    private String role;
    private List<Object> credentials;
    private String userId;
    private String createdDate;
    private String createdBy;
    private String lastModifiedBy;
    private String lastModifiedDate;

}
