package com.example.ems_backend.service.impl;

import com.example.ems_backend.dto.EmployeeDTO;
import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.exception.ResourceNotFoundExcecption;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.repository.EmployeeRepository;
import com.example.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.maptoEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundExcecption("Employee does not exist with given ID " + employeeId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> allEmployee = employeeRepository.findAll();
        return allEmployee.stream().map((emp) -> EmployeeMapper.mapToEmployeeDTO(emp)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployeeById(Long employeeId,EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundExcecption("Employee does not exist with given Id: " + employeeId));
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        Employee saveUpdatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(saveUpdatedEmployee);

    }

    @Override
    public void deleteEmployeeByID(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundExcecption("Employee does not exist with given Id: " + employeeId));
        employeeRepository.deleteById(employeeId);
    }


}
