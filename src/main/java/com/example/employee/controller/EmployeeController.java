package com.example.employee.controller;

import java.util.List;

import com.example.employee.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public ResponseEntity<Response> createEmployee(@RequestBody Employee emp) {
		Employee employee = new Employee();
	    employee =  empService.createEmployee(emp);


		Response customResponse = new Response();
		customResponse.setResponseMessage("Employee created");
		customResponse.setResponseStatus("Success");
		customResponse.setResponseObject(employee);

		return new ResponseEntity<Response>(customResponse, HttpStatus.OK);
	}

	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public ResponseEntity<Response> readEmployees() {
		List<Employee> employees;
		employees =  empService.getEmployees();


		Response customResponse = new Response();
		customResponse.setResponseMessage("All employees");
		customResponse.setResponseStatus("Success");
		customResponse.setResponseObject(employees);

		return new ResponseEntity<Response>(customResponse, HttpStatus.OK);

	}
	
	@RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
	    return empService.updateEmployee(id, empDetails);
	}
	
	@RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
	public void deleteEmployees(@PathVariable(value = "empId") Long id) {
	    empService.deleteEmployee(id);
	}
}



