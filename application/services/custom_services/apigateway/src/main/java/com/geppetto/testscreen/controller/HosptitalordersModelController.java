package com.geppetto.testscreen.controller;

import com.geppetto.testscreen.config.NewConstant;
import com.geppetto.testscreen.apiAdapter.ApiAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.Exception;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.jsonwebtoken.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class HosptitalordersModelController {

    @Autowired
    private ApiAdapter apiAdapter;



@PostMapping("/testfeature")
public ResponseEntity<Object> GpCreate(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into HosptitalordersModelController : GpCreate");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.post(NewConstant.TESTFEATUREURL + "/testfeature",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into HosptitalordersModelController : GpCreate");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/testfeature")
public ResponseEntity<Object> GpGetAllValues(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into HosptitalordersModelController : GpGetAllValues");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTFEATUREURL + "/testfeature",request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into HosptitalordersModelController : GpGetAllValues");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/testfeature/{id}")
public ResponseEntity<Object> GpGetEntityById( @PathVariable String id,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into HosptitalordersModelController : GpGetEntityById");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTFEATUREURL + "/testfeature/"+id,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into HosptitalordersModelController : GpGetEntityById");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/testfeature/get/search")
public ResponseEntity<Object> GpSearch(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into HosptitalordersModelController : GpSearch");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTFEATUREURL + "/testfeature/get/search",request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into HosptitalordersModelController : GpSearch");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@GetMapping("/testfeature/userid/created_by")
public ResponseEntity<Object> GpGetNounCreatedBy(HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into HosptitalordersModelController : GpGetNounCreatedBy");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.get(NewConstant.TESTFEATUREURL + "/testfeature/userid/created_by",request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into HosptitalordersModelController : GpGetNounCreatedBy");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@PutMapping("/testfeature/get/update")
public ResponseEntity<Object> GpSearchForUpdate(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into HosptitalordersModelController : GpSearchForUpdate");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.put(NewConstant.TESTFEATUREURL + "/testfeature/get/update",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into HosptitalordersModelController : GpSearchForUpdate");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@PutMapping("/testfeature")
public ResponseEntity<Object> GPUpdate(@RequestBody Object object,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into HosptitalordersModelController : GPUpdate");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.put(NewConstant.TESTFEATUREURL + "/testfeature",object,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into HosptitalordersModelController : GPUpdate");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

@DeleteMapping("/testfeature/{id}")
public ResponseEntity<Object> GpDelete( @PathVariable String id,HttpServletRequest request, HttpServletResponse response) throws IOException{
        log.info("Enter into HosptitalordersModelController : GpDelete");
        try{
            String servletPath = request.getContextPath();
                    switch (servletPath) {
                        case "/mobile":
                        case "/web":
          Object result= apiAdapter.delete(NewConstant.TESTFEATUREURL + "/testfeature/"+id,request);
          return ResponseEntity.ok(result);
          default:
                    String errorMessage = "Invalid servlet path: " + servletPath;
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                    }
        }
        catch(Exception e){
        log.info("Exit into HosptitalordersModelController : GpDelete");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }







    }

