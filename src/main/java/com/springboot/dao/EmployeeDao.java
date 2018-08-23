package com.springboot.dao;

import java.util.List;

import com.springboot.pojo.Employee;

public interface EmployeeDao {

	List<Employee> viewAllEmployees();
	void addNewEmployee(Employee employee);
	void deleteEmployee(String id);
	void updateEmployee(Employee employee, String id);
	Employee getEmployeeById(String id);
}