package com.example.employeepayroll.repository;


import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<Employee, Integer> {

}