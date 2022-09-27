package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.EmpService.EmployeeService;
import com.example.demo.Entity.Emp;




@RestController
public class Controller {
	@Autowired
	 private EmployeeService employeeService;
	
	
	@PostMapping("/save")
	public Emp saveEmp(@RequestBody Emp employee) {
		return employeeService.saveEmp(employee);
	}
		
	
	@GetMapping("/findAll")
	public List<Emp> getAllData(Emp employee) {
		//return employeeRepositary.findAll();
		return employeeService.getAllEmp(employee);
	}
	
	
	@GetMapping("/findById")
	 public Emp findById(@RequestParam int empId){
			return employeeService.findById(empId);		
			}
	
	
	@DeleteMapping("/deleteById/{empId}")
	public int deleteEmp(@PathVariable int empId) {
		 employeeService.deleteById(empId);
		 return empId;
		 
	}
	
	
	@PutMapping("/update/{empId}")
	public Emp updateEmp(@RequestBody Emp employee) {
		employeeService.updateEmpById(employee);
		return employee;
	}
	
	
	
	

}
