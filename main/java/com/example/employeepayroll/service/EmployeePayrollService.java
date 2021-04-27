package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.repository.IEmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private IEmployeePayrollRepository empRepo;

    @Override
    public ResponseDTO getEmployees() {
        return new ResponseDTO("Here are all the employees in the Database", empRepo.findAll());
    }

    public ResponseDTO addEmployees(EmployeePayrollDTO employee) {
        Employee emp = new Employee(employee);
        return new ResponseDTO("Employee Added To Database Successfully", empRepo.save(emp));
    }

    @Override
    public ResponseDTO findById(int id) {
        return new ResponseDTO("The Employee Details for the provided Id are", empRepo.findById(id).get());
    }

    @Override
    public void deleteEmployee(int id) {
        empRepo.deleteById(id);;
    }

    @Override
    public ResponseDTO updateName(int id, EmployeePayrollDTO emp) {
        return new ResponseDTO("Here are the Updated Details of the Employee", empRepo.save(new Employee(id, emp)));
    }

    @Override
    public ResponseDTO findEmployee(int id) {
        return new ResponseDTO("Employee By the Given ID is:", empRepo.findById(id).orElseThrow(()-> new PayrollException(exceptionType.EMPLOYEE_NOT_FOUND, "No Employee Found with such ID")));
    }

}