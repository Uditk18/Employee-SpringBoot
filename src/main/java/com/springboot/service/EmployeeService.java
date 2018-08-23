package com.springboot.service;

import java.util.List;

import com.springboot.pojo.Employee;

public interface EmployeeService {

	

	List<Employee> viewAllEmployees();
	void addNewEmployee(Employee employee);
	void deleteEmployee(String id);
	void updateEmployee(Employee employee, String id);
	void getEmployeeById(String id);
	
}
