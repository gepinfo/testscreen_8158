package com.geppetto.testscreen.controller;

import com.geppetto.testscreen.dto.HosptitalordersDto;
import com.geppetto.testscreen.service.HosptitalordersService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
* REST controller for managing Hosptitalorders
* Provides endpoints to create, update, delete, retrieve, and search for Hosptitalorders,
* as well as to handle file uploads and downloads associated with Hosptitalorders.
*/
@RestController
@RequestMapping("/testfeature")
@RequiredArgsConstructor
@Slf4j
public class HosptitalordersController {

   private final HosptitalordersService hosptitalordersService; 


@GetMapping("/{id}")
public ResponseEntity<HosptitalordersDto> getHosptitalordersById(@PathVariable String id) {
    log.info("Enter into getHosptitalordersById method");
    ResponseEntity<HosptitalordersDto> response =ResponseEntity.status(HttpStatus.OK).body(hosptitalordersService.getHosptitalordersById(id));
    log.info("Exit from getHosptitalordersById method");
    return response;
}

@PostMapping
public ResponseEntity<HosptitalordersDto> createHosptitalorders(@Valid @RequestBody HosptitalordersDto hosptitalordersDto) {
    log.info("Enter into createHosptitalorders method");
    ResponseEntity<HosptitalordersDto> response =  ResponseEntity.status(HttpStatus.OK).body(hosptitalordersService.createHosptitalorders(hosptitalordersDto));
    log.info("Exit from createHosptitalorders method");
    return response;
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteHosptitalorders(@PathVariable String id) {
    log.info("Enter into deleteHosptitalorders method");
     ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).body(hosptitalordersService.deleteHosptitalorders(id));
    log.info("Exit from deleteHosptitalorders method");
    return response;
}

@PutMapping
public ResponseEntity<HosptitalordersDto> updateHosptitalorders(@Valid @RequestBody HosptitalordersDto hosptitalordersDto) {
    log.info("Enter into updateHosptitalorders method");
    ResponseEntity<HosptitalordersDto> response = ResponseEntity.status(HttpStatus.OK).body(hosptitalordersService.updateHosptitalorders(hosptitalordersDto));
    log.info("Exit from updateHosptitalorders method");
    return response;
}

@GetMapping
public ResponseEntity<Page<HosptitalordersDto>> getAllHosptitalorders(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size) {
    log.info("Enter into getAllHosptitalorders method");
    Page<HosptitalordersDto>hosptitalordersDtoPage = hosptitalordersService.getAllHosptitalorders(page, size);
    log.info("Exit from getAllHosptitalorders method");
    return new ResponseEntity<>(hosptitalordersDtoPage, HttpStatus.OK);
}

   
}
