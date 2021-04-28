package com.example.employeepayroll.dto;

import lombok.Data;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@Data
    public class EmployeePayrollDTO {

        @NotEmpty
        @Pattern(regexp = "[A-Z]{1}+[a-z]{2,}", message = "Employee Name Invalid (Starts with Capital Letter, Should Not Contain Numbers, Length more than 3)")
        private String name;

        @NotEmpty(message = "Address Cannot be Empty")
        private String address;

        @NotEmpty(message = "Email Cannot be empty")
        @Email
        private String email;

        @NotNull(message = "Phone Number Cannot be Empty")
        private long pno;

        @NotNull
        @Min(value = 200000, message = "Salary Should be more than 2 LPA")
        private double salary;

        @NotNull
        private List<String> department;

        //	@JsonFormat(pattern = "yyyy-mm-dd")
        @NotNull(message = "Date cannot be Empty")
//	@PastOrPresent(message = "Date cannot be of future")
        private String start;

    }


    }
