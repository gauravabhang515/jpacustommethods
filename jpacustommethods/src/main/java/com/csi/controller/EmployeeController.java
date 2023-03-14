package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")

    public ResponseEntity<Employee> signUp(@Valid  @RequestBody Employee employee){

        return new ResponseEntity<>(employeeServiceImpl.signUp(employee), HttpStatus.CREATED);
    }
    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId,String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }
    @GetMapping("/getdatabyid/{empId}")

    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){

        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }
    @GetMapping("/getalldata")
    public List<Employee> getAllData(){

        return employeeServiceImpl.getAllData();
    }
    @DeleteMapping("/deletebyid/{empId}")

    public ResponseEntity<String> deleteById(@PathVariable int empId){
        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("id does not existt"));


        employeeServiceImpl.deleteById(employee1.getEmpId());
        return ResponseEntity.ok("deleted");
    }
    @GetMapping("/getdatabyfirstname/{empFirstName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empFirstName){
        return ResponseEntity.ok(employeeServiceImpl.findByEmpFirstName(empFirstName));
    }
    @GetMapping("/getdatabycontactnumber/{empContactNumber}")

    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable String empContactNumber){

        return ResponseEntity.ok(employeeServiceImpl.findByEmpContactNumber(empContactNumber));

    }
    @GetMapping("findbyempfirstnameandlastname/{empFirstName}/{empLastName}")

    public ResponseEntity<List<Employee>>getDataByEmpFirstNameAndEmpLastName(@PathVariable String empFirstName,String empLastName){

        return ResponseEntity.ok(employeeServiceImpl.findByEmpFirstNameAndEmpLastName(empFirstName,empLastName));
    }
    @GetMapping("/getdatabyemailid/{empEmailId}")

    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.findByEmpEmailId(empEmailId));

    }
   @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId,@Valid @RequestBody Employee employee){
        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RecordNotFoundException("id does not existt"));

        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpLastName(employee.getEmpLastName());

        return new ResponseEntity<>(employeeServiceImpl.updataData(employee1),HttpStatus.CREATED);
   }
   @PostMapping("/savebulkofdata")
    public ResponseEntity<String> saveBulkOfData(@Valid @RequestBody List<Employee> employees){

        employeeServiceImpl.saveBulkOfData(employees);
        return ResponseEntity.ok("Save all data succefully");
   }
   @GetMapping("/getdatabyanyinput/{input}")

    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input){

        List<Employee>employeeList = new ArrayList<>();

        for (Employee employee:employeeServiceImpl.getAllData()){
            if (employee.getEmpFirstName().equals(input)||
                    employee.getEmpEmailId().equals(input)||
            employee.getEmpAddress().equals(input)){
                employeeList.add(employee);
            }
        }
        return ResponseEntity.ok(employeeList);
   }
}
