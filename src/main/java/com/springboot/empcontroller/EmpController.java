package com.springboot.empcontroller;

//Rest controller which handles all the dependencies and use annotations to perform actions
import java.util.List;

import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pojo.Employee;
import com.springboot.service.EmployeeService;
import com.springboot.service.EmployeeServiceImpl;

//Our program is a REST application and handles WEB Request
@RestController
public class EmpController {

	private EmployeeService empService = new EmployeeServiceImpl();

	/*
	 * @RequestMapping
	 *It maps HTTP Requests to handler methods of MVC and REST controllers
	 *GIves Routing information
	 *Its like RequestDispatcher of spring
	 *
	 */
	
	
	//GET Method to show list of all employees
	@RequestMapping("/employee")
	public List<Employee> viewEmployee() {
		return empService.viewAllEmployees();
	}
	
	//POST Method to add new employee
	/*
	 * @RequestBody binds the HttpRequest with a domain object in method parameter or return type,enabling automatic deserialization of the 
	 * inbound HttpRequest body onto the java object
	*/
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public void addNewEmployee( @RequestBody Employee employee) {
		empService.addNewEmployee(employee);
	}
	
	//GET method to get employee by id
	/*
	 * @PathVariable tells that we are passing a variable in the url
	*/
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Resource<Employee> getEmployee( @PathVariable String id) {
		Resource<Employee> resource=new Resource<Employee>(empService.getEmployeeById(id));
			return resource;
		}

	
	//DELETE Method to delete an employee
	//{id} tells that id is a variable
		/*
		 * @PathVariable tells that we are passing a variable in the url
		*/
	
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee( @PathVariable String id) {
			empService.deleteEmployee(id);
		}

	@RequestMapping(value="/employee/{id}", method = RequestMethod.PUT)
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
		empService.updateEmployee(employee,id);
	}		
	
}