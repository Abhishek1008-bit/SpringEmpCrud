package com.example.demo.EmpRepositaryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.EmpRepositary.EmployeeRepositary;
import com.example.demo.Entity.Emp;

@SpringBootTest

public class RepositaryTest {
	Emp emp;
	List<Emp> emplist;
	@Autowired
	EmployeeRepositary employeeRepositary;
	@BeforeEach
	void setup(){
		emp = getEmp();
	}
	
	
	/*@Test
	void addEmp() {
			emp=getEmp();
		    Emp saveEmp = employeeRepositary.save(emp);
		   // System.out.println("saveEmp:"+saveEmp);
		    assertEquals(emp.toString(), saveEmp.toString());
}
	
	@Test
	public void getAllEmp() {
		Emp e1 = new Emp();
		e1.setEmpId(1);
	    e1.setName("Gopal");
      	e1.setDesg("AAS");
  		e1.setSalary(8231);
  		employeeRepositary.save(e1);
  		List<Emp> empList = employeeRepositary.findAll();
  		assertThat(empList).isNotNull();
  		assertThat(empList.size()).isEqualTo(empList.size());
	}
	
	
	@Test
	void deleteEmp() {
		employeeRepositary.save(emp);
		employeeRepositary.deleteById(emp.getEmpId());
		Optional<Emp> empOptional = employeeRepositary.findById(emp.getEmpId());
		assertThat(empOptional).isEmpty();
	}
	
	@Test
	void updateEmp() {
		employeeRepositary.save(emp);
		Emp saveEmp = employeeRepositary.findById(emp.getEmpId()).get();
		System.out.println(saveEmp.toString());
		saveEmp.setEmpId(53);
		saveEmp.setName("Akash");
		saveEmp.setDesg("Hr");
		saveEmp.setSalary(155224);
		 Emp updatedStudent = employeeRepositary.save(saveEmp);
		 assertEquals(saveEmp.toString(), updatedStudent.toString());
	}*/
		
	private Emp getEmp() {
		Emp emp=new Emp();
		emp.setEmpId(53);
		emp.setName("abhishak");
		emp.setSalary(123456);
		emp.setDesg("esc");
		return emp;
		
	}

}
