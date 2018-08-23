package com.springboot.service;

import java.util.List;

import com.springboot.dao.EmployeeDao;
import com.springboot.dao.EmployeeDaoImpl;
import com.springboot.pojo.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public List<Employee> viewAllEmployees() {
		return dao.viewAllEmployees();
	}

	@Override
	public void addNewEmployee(Employee employee) {
		dao.addNewEmployee(employee);
	}

	public void deleteEmployee(String id) {
		dao.deleteEmployee(id);
	}

	@Override
	public void updateEmployee(Employee employee, String id) {
		dao.updateEmployee(employee, id);
	}

	public void getEmployeeById(String id)
	{
		dao.getEmployeeById(id);
	}

	@Override
	public void addNewEmployee(com.springboot.service.Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(com.springboot.service.Employee employee, String id) {
		// TODO Auto-generated method stub
		
	}

}
