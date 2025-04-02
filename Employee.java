package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Employee 
{
    
	private Integer empno;
	@NonNull
	private String empname;
	@NonNull
	private String job;
	@NonNull
	private Double salary;
	@NonNull
	private Integer deptNo;
	private Double grossSalary;
	private Double netSalary;
	
	
}
