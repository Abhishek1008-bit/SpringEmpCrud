package com.example.demo.EmpService;

import java.util.List;


import com.example.demo.Entity.Emp;




public interface EmployeeService {
	public Emp saveEmp(Emp employee);
	public List<Emp> getAllEmp(Emp employee);
	 public Emp findById(int id);
	 public int deleteById(int id);
	public Emp updateEmpById(Emp employee);
	
}
