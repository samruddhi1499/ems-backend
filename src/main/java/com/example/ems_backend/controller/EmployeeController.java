package com.example.ems_backend.controller;

import com.example.ems_backend.dto.EmployeeDTO;
import com.example.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    
    private EmployeeService employeeService;
    
    // build app employee REST API

    @PostMapping
    public ResponseEntity<EmployeeDTO> creatEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    // build get employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeById = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeById,HttpStatus.OK);
    }
    // biuld get all emp rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }
    // build update emp REst API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable("id") Long employeeId, @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO updatedEmployee = employeeService.updateEmployeeById(employeeId, employeeDTO);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);

    }
    // build delete emp REst API
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeByID(employeeId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
