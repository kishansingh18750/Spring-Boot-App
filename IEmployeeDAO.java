package com.nt.dao;
//DAO interface
import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO 
{
public List<Employee> getEmployeeByDesgs(String desg1,String desg2,String desg3) throws Exception;
	public int insertEmployee(Employee emp)throws Exception;
	public int deletEmp(Employee emp)throws Exception;
	public int editEmployeeData(Employee emp) throws Exception;
}
