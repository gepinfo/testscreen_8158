package com.default_service.gcam.service.imple;

import com.default_service.gcam.Exception.BusinessException;
import com.default_service.gcam.Exception.ErrorCode;
import com.default_service.gcam.dao.ResourceDao;
import com.default_service.gcam.dao.ScreenDao;
import com.default_service.gcam.dto.RequestDto;
import com.default_service.gcam.dto.ResourceRequestDto;
import com.default_service.gcam.dto.ResourceResponseDto;
import com.default_service.gcam.model.Resource;
import com.default_service.gcam.model.Screen;
import com.default_service.gcam.service.GcamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GcamServiceImple implements GcamService {

    @Autowired
    private ScreenDao screenDao;

    @Autowired
    private ResourceDao resourceDao;

    private String role;



        @Override
    public void saveResourceAndScreensFromJson(String filesPath) throws BusinessException {
        log.info("Enter into saveResourceAndScreensFromJson:GcamServiceImple");
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> listOfFileName = Arrays.asList("resource.json", "screen.json");

        try {
            /*Save Resource*/
            String resourceFilePath = filesPath.concat(listOfFileName.get(0));
            List<Resource> newResources = Arrays.asList(objectMapper.readValue(new File(resourceFilePath), Resource[].class));
            List<Resource> existingResources = resourceDao.getAllResource();

            for (Resource newResource : newResources) {
                boolean resourceExists = existingResources.stream()
                        .anyMatch(existingResource -> existingResource.getId().equals(newResource.getId()));

                if (resourceExists) {
                    Resource existingResource = existingResources.stream()
                            .filter(resource -> resource.getId().equals(newResource.getId()))
                            .findFirst()
                            .orElse(null);

                    if (existingResource != null) {
                        existingResource.setResource_name(newResource.getResource_name());
                        existingResource.setResource_type(newResource.getResource_type());
                        existingResource.setId(newResource.getId());
                        existingResource.setCreated_at(new Date());
                        existingResource.setRoles(newResource.getRoles());
                        existingResource.setComponents(newResource.getComponents());
                    }
                } else {
                    resourceDao.saveResource(newResource);
                }
            }
            existingResources.stream()
                    .filter(existingRole -> newResources.stream().noneMatch(newResource -> newResource.getId().equals(existingRole.getId())))
                    .forEach(resourceDao::deleteResource);

            /*Save Screen*/
            String screenFilePath = filesPath.concat(listOfFileName.get(1));
            List<Screen> newScreens = Arrays.asList(objectMapper.readValue(new File(screenFilePath), Screen[].class));
            List<Screen> existingScreens = screenDao.findAllScreens();

            for (Screen newScreen : newScreens) {
                boolean screenExists = existingScreens.stream()
                        .anyMatch(existingScreen -> existingScreen.getId().equals(newScreen.getId()));

                if (screenExists) {
                    Screen existingScreen = existingScreens.stream()
                            .filter(screen -> screen.getId().equals(newScreen.getId()))
                            .findFirst()
                            .orElse(null);

                    if (existingScreen != null) {
                        existingScreen.setId(newScreen.getId());
                        existingScreen.setRole(newScreen.getRole());
                        existingScreen.setResources(newScreen.getResources());
                        existingScreen.setCreated_at(new Date());
                    }
                } else {
                    screenDao.saveScreen(newScreen);
                }
            }
            existingScreens.stream()
                    .filter(existingScreen -> newScreens.stream().noneMatch(newScreen -> newScreen.getId().equals(existingScreen.getId())))
                    .forEach(screenDao::deleteScreen);

            log.info("Exit from saveResourceAndScreensFromJson:GcamServiceImple");
        } catch (BusinessException | IOException exception) {
            log.info("Error from saveResourceAndScreensFromJson:GcamServiceImple");
            throw new BusinessException(ErrorCode.INCORRECT_DATA.code(), ErrorCode.INCORRECT_DATA.message());
        }
    }

    public ResponseEntity<List<ResourceResponseDto>> getAllResource() {
        log.info("Enter into getAllResource:GcamServiceImple");
        List<Resource> resourceList = resourceDao.getAllResource();

        List<ResourceResponseDto> resourceResponseDtoList = resourceList.stream()
                .map(resource -> {
                    ResourceResponseDto resourceDto = new ResourceResponseDto();
                    BeanUtils.copyProperties(resource, resourceDto);
                    return resourceDto;
                })
                .collect(Collectors.toList());

        log.info("Exit from getAllResource:GcamServiceImple");
        return ResponseEntity.ok(resourceResponseDtoList);
    }

    public ResponseEntity<List<ResourceResponseDto>> getResourceAuthorizationByRole(RequestDto requestDto) {
        log.info("Enter into getResourceAuthorizationByRole:GcamServiceImple");
        log.info("Received roles: {}", requestDto);

        List<String> roles = requestDto.getListOfRoles().stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        List<Resource> resourceList = resourceDao.getResourceAuthorizationByRole(roles);
        List<ResourceResponseDto> resourceResponseDtoList = resourceList.stream()
                .map(resource -> {
                    ResourceResponseDto resourceDto = new ResourceResponseDto();
                    BeanUtils.copyProperties(resource, resourceDto);
                    return resourceDto;
                })
                .collect(Collectors.toList());

        log.info("Exit from getResourceAuthorizationByRole:GcamServiceImple");
        return ResponseEntity.ok(resourceResponseDtoList);
    }

    public ResponseEntity<ResourceResponseDto> getResourceById(String id) {
        log.info("Enter into getResourceById:GcamServiceImple");
        ResourceResponseDto resourceResponseDto = new ResourceResponseDto();

        if (resourceDao.existsById(id)) {
            Resource resource = resourceDao.getResourceById(id);
            BeanUtils.copyProperties(resource, resourceResponseDto);
        } else {
            log.warn("Resource not found for ID: {}", id);
            return ResponseEntity.notFound().build();
        }

        log.info("Exit from getResourceById:GcamServiceImple");
        return ResponseEntity.ok(resourceResponseDto);
    }

    public ResponseEntity<ResourceResponseDto> updateResource(ResourceRequestDto resourceRequest) {
        log.info("Enter into updateResource:GcamServiceImple");
        ResourceResponseDto resourceDto = new ResourceResponseDto();

        if (resourceDao.existsById(resourceRequest.getId())) {
            Resource resource = new Resource();
            BeanUtils.copyProperties(resourceRequest, resource);
            Resource updatedResource = resourceDao.gcamUpdate(resource);
            BeanUtils.copyProperties(updatedResource, resourceDto);
        } else {
            log.warn("Resource not found for update with ID: {}", resourceRequest.getId());
            return ResponseEntity.notFound().build();
        }

        log.info("Exit from updateResource:GcamServiceImple");
        return ResponseEntity.ok(resourceDto);
    }

    public void deleteResource(String id) {
        log.info("Enter into deleteResource:GcamServiceImple");
        if (resourceDao.existsById(id)) {
            resourceDao.gcamDelete(id);
            log.info("Deleted resource with ID: {}", id);
        } else {
            log.warn("Attempted to delete non-existent resource with ID: {}", id);
        }
        log.info("Exit from deleteResource:GcamServiceImple");
    }

    public ResponseEntity<Map<String, Object>> GcamGgenerate(Map<String, Object> request) {
        return null;
    }

    public String datatransform(List<Resource> resources) {
        JSONArray transformedArray = new JSONArray();
        JSONObject transformedData = new JSONObject();
        JSONArray accessArray = new JSONArray();

        for (Resource resource : resources) {
            JSONArray rolesArray = new JSONArray(resource.getRoles());
            String resourceName = resource.getResource_name();

            for (int j = 0; j < rolesArray.length(); j++) {
                String role = rolesArray.getString(j);
                JSONObject screenObject = new JSONObject();
                screenObject.put("screenname", resourceName);
                JSONArray componentsArray = new JSONArray();

                JSONObject componentsObject = new JSONObject();
                JSONObject componentDetails = new JSONObject();
                componentDetails.put("type", "string");
                componentDetails.put("id", "true");

                componentsObject.put("label_1425", componentDetails);
                componentsObject.put("textbox_6272", componentDetails);
                componentsObject.put("label_2437", componentDetails);
                componentsObject.put("dropdown_73821", componentDetails);

                componentsArray.put(componentsObject);
                screenObject.put("components", componentsArray);
                accessArray.put(new JSONObject().put(role, new JSONArray().put(screenObject)));
            }
        }

        transformedData.put("access", accessArray);
        transformedArray.put(transformedData);
        return transformedArray.toString();
    }
}

