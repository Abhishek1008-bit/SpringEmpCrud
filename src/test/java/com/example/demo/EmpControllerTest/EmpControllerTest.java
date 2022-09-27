package com.example.demo.EmpControllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.Controller.Controller;

import com.example.demo.EmployeeServiceImpl.EmployeeServiceImpl;
import com.example.demo.Entity.Emp;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
public class EmpControllerTest {
	@InjectMocks                    
	Controller empController;
	
	
	private MockMvc mockMvc;
	

	
	@Autowired
	WebApplicationContext context;
	ObjectMapper objectMapper = new ObjectMapper();
	@Mock
	EmployeeServiceImpl employeeServiceImpl;   //DUmmy
   
	Emp empDummy1;
    
//	Emp empDummy2;
	List<Emp> empList;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(empController).build();
		empDummy1  = getData();
		empList = getEmpList();
		}
	
	
	@Test
	public void saveEmps() throws Exception {
		    String jsonRequest  = objectMapper.writeValueAsString(empDummy1);
		    when(employeeServiceImpl.saveEmp(Mockito.any(Emp.class))).thenReturn(empDummy1);
		    MvcResult mvcResult =  mockMvc.perform(post("/save").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).
		    andExpect(status().isOk()).andReturn();
		  String expectOutput =   mvcResult.getResponse().getContentAsString();
		    Emp expectedOutput = objectMapper.readValue(expectOutput, Emp.class);
		    assertEquals(expectedOutput.getEmpId(), empDummy1.getEmpId());
		 	}
	
	
	
	
	@Test
	public void updateEmps() throws Exception {
		  String jsonRequest = objectMapper.writeValueAsString(empDummy1);
		  when(employeeServiceImpl.updateEmpById(Mockito.any(Emp.class))).thenReturn(empDummy1);
		    MvcResult mvcResult = mockMvc.perform(put("/update/{empId}",empDummy1.getEmpId()).content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
		  .andExpect(status().isOk()).andReturn();
		     String expectedResult =  mvcResult.getResponse().getContentAsString();
		        Emp expectedOutputEmp =   objectMapper.readValue(expectedResult, Emp.class);
		  assertEquals(expectedOutputEmp.getEmpId(), empDummy1.getEmpId());
	}
	
	
	
	@Test
	public void deleteEmps() throws Exception {
		String jsonRequest = String.valueOf(empDummy1.getEmpId());
		when(employeeServiceImpl.findById(Mockito.anyInt())).thenReturn(empDummy1);
		MvcResult mvcResult = mockMvc.perform(delete("/deleteById/{empId}", jsonRequest))
		.andExpect(status().isOk()).andReturn();
		String expectOutput = mvcResult.getResponse().getContentAsString();
		 int id = Integer.parseInt(expectOutput);
		 assertEquals(id, empDummy1.getEmpId());
		 
	}

	@Test
	public void getAllEmps() throws Exception {
	 when(employeeServiceImpl.updateEmpById(Mockito.any(Emp.class))).thenReturn(empDummy1);
	 MvcResult mvcResult =  mockMvc.perform(get("/findAll"))
	 .andExpect(status().isOk()).andReturn();
	  int status = mvcResult.getResponse().getStatus();
	  assertEquals(200, status);
	}
	
	
	
	
	/*
	 * @Test
	public void getAllEmp() {
		when(employeeServiceImpl.getAllEmp(empDummy1)).thenReturn(empList);
	  	 List<Emp> actualEmpList = empController.getAllData(empDummy1);
		assertEquals(actualEmpList.size(), empList.size());
	}
	 *
	 * @Test
	public void deleteEmp() {
		when(employeeServiceImpl.findById(Mockito.anyInt())).thenReturn(empDummy1);
		   int id = empController.deleteEmp(empDummy1.getEmpId());
		   assertEquals(empDummy1.getEmpId(), id);
	}
	
	*
	@Test
	public void updateEmp() {
		when(employeeServiceImpl.updateEmpById(empDummy1)).thenReturn(empDummy1);
		     Emp actualResult = empController.updateEmp(empDummy1);
		     assertEquals(empDummy1.toString(),actualResult.toString());
}

*
@Test
	public void saveEmp() {
		when(employeeServiceImpl.saveEmp(Mockito.any(Emp.class))).thenReturn(empDummy1);
		  Emp actualResult = empController.saveEmp(empDummy1);
		assertEquals(empDummy1.toString(), actualResult.toString());
	}
	*/

        private Emp getData() {
		Emp e1 = new Emp();
		e1.setEmpId(1);
		e1.setName("Abhi");
		e1.setDesg("ASE");
		e1.setSalary(1000);
		return e1;
		
	}
	  private List<Emp> getEmpList(){
		 List<Emp> empList = new ArrayList<>();
		 Emp e1 = new Emp();
			e1.setEmpId(1);
			e1.setName("Abhi");
			e1.setDesg("ASE");
			e1.setSalary(1000);
			
			Emp e2 = new Emp();
			e2.setEmpId(2);
			e2.setName("Abhas");
			e2.setDesg("ASE");
			e2.setSalary(10000);
			empList.add(e2);
			empList.add(e1);
			
			return empList;
		}
	
}
