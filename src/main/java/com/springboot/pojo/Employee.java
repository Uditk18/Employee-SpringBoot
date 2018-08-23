package com.springboot.pojo;

//Pojo class defining all the instance methods and variables

import org.springframework.hateoas.ResourceSupport;

public class Employee extends ResourceSupport {
	private String empId;
	private String empName;

	public Employee() {
	}

	public Employee(String empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee Details : /n [empId=" + empId + ", empName=" + empName + "]";
	}

}