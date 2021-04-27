package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.dto.ResponseDTO;

public interface IEmployeePayrollService {

    ResponseDTO getEmployees();

    ResponseDTO addEmployees(EmployeePayrollDTO employee);

    ResponseDTO findById(int id);

    void deleteEmployee(int id);

    ResponseDTO updateName(int id, EmployeePayrollDTO emp);

    ResponseDTO findEmployee(int id);
}