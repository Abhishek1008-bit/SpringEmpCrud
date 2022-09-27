package com.example.demo.EmpServiceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.EmpRepositary.EmployeeRepositary;
import com.example.demo.EmployeeServiceImpl.EmployeeServiceImpl;
import com.example.demo.Entity.Emp;
@SpringBootTest
public class EmpServiceTest {
	Emp empDummy;
	Emp empDummy2;
	List<Emp> empList;
	
   @InjectMocks   // Originally call 
	EmployeeServiceImpl employeeServiceImpl;
	@Mock        // Originally call Dummy
	EmployeeRepositary employeeRepositary;
	
     @BeforeEach
    void setUp() {
	empList = getEmpList();
	empDummy  = getEmp();
    empDummy2 = getEmp();
	
	}
	
	@Test
	 void saveEmpTest()
	{
		when(employeeRepositary.save(Mockito.any(Emp.class))).thenReturn(empDummy2); //dummy
		  Emp actualResult  = employeeServiceImpl.saveEmp(empDummy2);
		  assertEquals(actualResult,empDummy2);
	}	
	
	@Test 
	void getAllEmpTest() {
		when(employeeRepositary.findAll()).thenReturn(empList);
		 List<Emp> actualResult = employeeServiceImpl.getAllEmp(empDummy);
		 assertEquals(actualResult.size(),empList.size());
	}
	
	@Test
   public  void deleteEmp() {
		when(employeeRepositary.findById(Mockito.anyInt())).thenReturn(Optional.of(empDummy));
        int em = employeeServiceImpl.deleteById(empDummy.getEmpId());
        assertEquals(empDummy.getEmpId(), em);
		
	}
	
	@Test
	void updateEmpTest() {
		when(employeeRepositary.findById(Mockito.anyInt())).thenReturn(Optional.of(empDummy));
		when(employeeRepositary.save(Mockito.any(Emp.class))).thenReturn(empDummy2);
		Emp actualResult  = employeeServiceImpl.updateEmpById(empDummy2);
		assertEquals(empDummy2.toString(), actualResult.toString());
	}
	
	private Emp getEmp() {
		Emp emp = new Emp();
		emp.setEmpId(1);
		emp.setName("Abhi");
		emp.setDesg("Ase");
		emp.setSalary(4552);
		return emp;
	}
	
	
	private List<Emp> getEmpList(){
		List<Emp> empList = new ArrayList<>();
		Emp e1 = new Emp();
		e1.setEmpId(2);
		e1.setName("Shubham");
		e1.setDesg("Vp");
		e1.setSalary(5456);
		
		Emp e2 = new Emp();
		e2.setEmpId(2);
		e2.setName("Akash");
		e2.setDesg("BA");
		e2.setSalary(7852);
		
		empList.add(e2);
		empList.add(e1);
		return empList;
	}
		
			
}
