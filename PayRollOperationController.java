package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("empController")
public class PayRollOperationController 
{
	@Autowired
	private IEmployeeMgmtService empService;
	
	public List<Employee> featchEmployeeDesgs(String desg1,String desg2,String desg3)throws Exception
	{
		desg1= desg1.toUpperCase();
		desg2= desg2.toUpperCase();
		desg3= desg3.toUpperCase();
	return	empService.showEmployeeByDesgs(desg1, desg2, desg3);
	
		
	}
	public String processEmployee(Employee emp)throws Exception
	{
		String resultmsg= empService.registerEmployee(emp);
		
		return resultmsg;
	}
	
	public String deleteEmpData(Employee emp)throws Exception
	{
		return empService.processDelete(emp);
		
	}
	public String ProcessEmployeeEditing(Employee emp)throws Exception{
		String msg= empService.editEmployee(emp);
		return msg;
	}
	
	
}

