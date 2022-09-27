package com.example.demo.EmpRepositary;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Emp;

@Repository
public interface EmployeeRepositary extends JpaRepository<Emp, Integer>{
	

}
