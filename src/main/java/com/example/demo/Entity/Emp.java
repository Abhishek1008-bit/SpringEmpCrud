package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_final")

public class Emp {

	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int empId;
		private String name;
		private String desg;
		private int salary;
		//empId,name,desg,salary

		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDesg() {
			return desg;
		}
		public void setDesg(String desg) {
			this.desg = desg;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Emp [empId=" + empId + ", name=" + name + ", desg=" + desg + ", salary=" + salary + "]";
		}
		
		
		

}
