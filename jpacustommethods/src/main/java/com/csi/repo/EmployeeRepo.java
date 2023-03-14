package com.csi.repo;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    public List<Employee> findByEmpFirstName(String empFirstName);

    public Employee findByEmpContactNumber(String empContactNumber);

    public List<Employee> findByEmpFirstNameAndEmpLastName(String empFirstName,String empLastName);

    public Employee findByEmpEmailId(String empEmailId);

    public List<Employee> findByEmpEmailIdAndEmpPassword(String empEmailId,String empPassword);
}
