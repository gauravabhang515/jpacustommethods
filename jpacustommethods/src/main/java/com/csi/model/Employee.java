package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue

    private int empId;


    @Size(min = 2, message = "At least 2 character")
    private String empFirstName;


    @Pattern(regexp = "[A-Za-z]*", message = "Last name should not contain space and special characters")
    private String empLastName;

    @NotNull
    private String empAddress;

    @Size(min = 10, max = 10, message = "Contact number must be 10 digit")
    @Column(unique = true)
    private String empContactNumber;

    private double empSalary;


    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Email(message = "email should be valid")
    @Column(unique = true)
    private String empEmailId;

    @Size(min = 4, message = "password should be atleast 4 character")
    private String empPassword;
}
