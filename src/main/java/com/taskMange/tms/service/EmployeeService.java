package com.taskMange.tms.service;

import com.taskMange.tms.model.Employee;
import com.taskMange.tms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository EmployeeRepository;

    //Find Employee by EmployeeId
    public Optional<Employee> findByEmployeeId(int EmployeeId){
        return EmployeeRepository.findById(EmployeeId);
    }

    public List<Employee> getAllEmployees(){
        return EmployeeRepository.findAll();
    }

    public Employee addEmployee(Employee Employee){
        return EmployeeRepository.save(Employee);
    }
}
