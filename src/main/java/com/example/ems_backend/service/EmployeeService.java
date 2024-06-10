package com.example.ems_backend.service;

import com.example.ems_backend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployeeById(Long employeeID, EmployeeDTO employeeDTO);

    void deleteEmployeeByID(Long employeeId);
}
