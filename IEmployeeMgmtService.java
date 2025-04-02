package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	
public List<Employee> showEmployeeByDesgs(String degs1,String degs2,String degs3)throws Exception;
public String registerEmployee(Employee emp)throws Exception;
public String processDelete(Employee emp)throws Exception;
public String editEmployee(Employee emp) throws Exception;

}
