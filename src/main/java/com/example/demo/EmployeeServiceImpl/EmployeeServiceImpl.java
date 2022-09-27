package com.example.demo.EmployeeServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmpRepositary.EmployeeRepositary;
import com.example.demo.EmpService.EmployeeService;

import com.example.demo.Entity.Emp;

@Service
public class EmployeeServiceImpl implements EmployeeService{
   
 
   @Autowired
   private EmployeeRepositary employeeRepositary;
	
	
	@Override
	public Emp saveEmp(Emp employee) {
		// TODO Auto-generated method stub
		System.out.println(employeeRepositary.save(employee));
		return employeeRepositary.save(employee);
	}

	@Override
	public List<Emp> getAllEmp(Emp employee) {
		// TODO Auto-generated method stub
		return employeeRepositary.findAll();
	}
	
	@Override
	public Emp findById(int id) {
	// TODO Auto-generated method stub
		return employeeRepositary.findById(id).get();
	}
	@Override
	public int deleteById(int empId) {
		 employeeRepositary.deleteById(empId);
		 return empId;
	}

	@Override
	public Emp updateEmpById(Emp employee) {
		Emp e1 =  employeeRepositary.findById(employee.getEmpId()).orElse(null);
		e1.setEmpId(employee.getEmpId());
		e1.setName(employee.getName());
		e1.setDesg(employee.getDesg());
		e1.setSalary(employee.getSalary());
		 return  employeeRepositary.save(employee);
	}

	

	
	
	
 




	

	

}
