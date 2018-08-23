package com.springboot.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Repository;

import com.springboot.empcontroller.EmpController;
import com.springboot.employeenotfound.EmployeeNotFoundException;
import com.springboot.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private Employee employee = null;
	// Making a list of employees
	// We use ArrayList to make it mutable
	List<Employee> employeeDB = new ArrayList<>(Arrays.asList(new Employee("1001", "Udit"),
			new Employee("1002", "Ripudaman"), new Employee("1003", "Rahul")));

	// method to view all employees
	public List<Employee> viewAllEmployees() {
		if (employeeDB.size() == 0) {
			throw new EmployeeNotFoundException("Employee Not Found");
		} else {
			return employeeDB;
		}
	}

	// method to add new employee

	public Employee getEmployeeById(String id) {
		try {
		employee = employeeDB.stream().filter(t -> t.getEmpId().equals(id)).findFirst().get();
		}
		catch(NoSuchElementException exception)
		{
			throw new EmployeeNotFoundException("Employee Not Found");

		}
			return employee;

	}

	// method to add new employee
	public void addNewEmployee(Employee employee) {

		Link link = ControllerLinkBuilder.linkTo(EmpController.class).slash(employee.getEmpName()).withSelfRel();
		employee.add(link);
		employeeDB.add(employee);

	}

	// method to delete an employee by id
	public void deleteEmployee(String id) {
		Predicate<Employee> emp = p -> p.getEmpId().equals(id);
		if (emp == null)
		{
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		else
		{
			employeeDB.removeIf(emp);
		}
	}

	// method to update an employee by id
	public void updateEmployee(Employee employee, String id) {
		for (int i = 0; i < employeeDB.size(); i++) {
			Employee emp = employeeDB.get(i);
			if (emp.getEmpId().equals(id)) {
				employeeDB.set(i, employee);
				return;
			}
		}
	}

}
