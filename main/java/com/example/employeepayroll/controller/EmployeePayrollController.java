package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/employeepayroll", ""})

public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService empPayrollService;
    /**
     * API to add new employee to DB
     * @param employee
     * @return Employee Data
     */
    @PostMapping("/addemployee")
    public ResponseEntity<ResponseDTO> addEmployees(@Valid @RequestBody EmployeePayrollDTO employee) {
        ResponseDTO emp =  empPayrollService.addEmployees(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    /**
     * API to list all the employees in DB
     * @return List of employee in Response Entity
     */
    @GetMapping({"/", "/all"})
    public ResponseEntity<ResponseDTO> getEmployees() {
        ResponseDTO emp =  empPayrollService.getEmployees();
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    /**
     * API to find employee by ID
     * @param id
     * @return Employee Data
     */
    @GetMapping("findemployee/{id}")
    public ResponseEntity<ResponseDTO> findByEmployee(@PathVariable int id) {
        return new ResponseEntity<ResponseDTO>(empPayrollService.findById(id), HttpStatus.FOUND);
    }

    /**
     * API to delete employee data from sql
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        empPayrollService.deleteEmployee(id);
    }

    /**
     * API for updation of different fields
     * @param id
     * @return Employee Data with updated fields
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateName(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO emp) {
        return new ResponseEntity<ResponseDTO>(empPayrollService.updateName(id, emp), HttpStatus.OK);
    }


    /**
     * API to find employee by ID with exception
     * @param id
     * @return Employee Data
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findEmployeeById(@PathVariable int id) {
        return new ResponseEntity<ResponseDTO>(empPayrollService.findEmployee(id), HttpStatus.FOUND);
    }

}
}
