package com.taskMange.tms.controller;

import com.taskMange.tms.model.Employee;
import com.taskMange.tms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee Employee){
        return new ResponseEntity<>(EmployeeService.addEmployee(Employee), HttpStatus.CREATED);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(EmployeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable("id") int id){
        return new ResponseEntity<>(EmployeeService.findByEmployeeId(id), HttpStatus.OK);
    }

}
