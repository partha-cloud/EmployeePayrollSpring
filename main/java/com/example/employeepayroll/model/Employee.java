package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String email;
    private long pno;
    private double salary;
    private LocalDate start;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name="id"))
    @Column(name = "department")
    private List<String> department;

    public Employee() {}

    public Employee(int id, EmployeePayrollDTO emp) {
        this.id = id;
        this.name = emp.getName();
        this.address = emp.getAddress();
        this.email = emp.getEmail();
        this.pno =	 emp.getPno();
        this.salary = emp.getSalary();
        this.department = emp.getDepartment();
        this.start = LocalDate.parse(emp.getStart());

    }

    public Employee(EmployeePayrollDTO employee) {
        this.name = employee.getName();
        this.address = employee.getAddress();
        this.email = employee.getEmail();
        this.pno =	 employee.getPno();
        this.salary = employee.getSalary();
        this.department = employee.getDepartment();
        this.start = LocalDate.parse(employee.getStart());
    }


}