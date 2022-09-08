package com.harshlata.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.harshlata.model.Employee;

public interface EmployeeService {
	
   public List<Employee> getAllEmployee();
   
   public void saveEmployee(Employee employee);
   
   public Employee getEmployeeById(long id);
   
   public void deleteEmployeeById(long id);
   
   public Page<Employee> findPaginated(int pageNo , int pageSize);
   

}
