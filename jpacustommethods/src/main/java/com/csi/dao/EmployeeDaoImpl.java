package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;


    public Employee signUp(Employee employee) {

        return employeeRepoImpl.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;
        if (employeeRepoImpl.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword).size() >= 1) {
            flag = true;

        }
        return flag;
    }

    public Optional<Employee> getDataById(int empId) {

        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> getAllData() {

        return employeeRepoImpl.findAll();
    }

    public void deleteById(int empId) {

        employeeRepoImpl.deleteById(empId);

    }

    public List<Employee> findByEmpFirstName(String empFirstName) {
        return employeeRepoImpl.findByEmpFirstName(empFirstName);
    }

    public Employee findByEmpContactNumber(String empContactNumber) {
        return employeeRepoImpl.findByEmpContactNumber(empContactNumber);
    }

    public List<Employee> findByEmpFirstNameAndEmpLastName(String empFirstName, String empLastName) {
        return employeeRepoImpl.findByEmpFirstNameAndEmpLastName(empFirstName, empLastName);
    }

    public Employee findByEmpEmailId(String empEmailId) {

        return employeeRepoImpl.findByEmpEmailId(empEmailId);
    }

    public List<Employee> findByEmpEmailIdAndEmpPassword(String empEmailId, String empPassword) {
        return employeeRepoImpl.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);
    }

    public Employee updataData(Employee employee) {
        return employeeRepoImpl.save(employee);

    }

    public void saveBulkOfData(List<Employee> employees) {
        for (Employee employee : employees) {
            employeeRepoImpl.save(employee);
        }
    }
    public List<Employee> getDataByAnyInput(String input){

        return employeeRepoImpl.findAll();
    }
}
