package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;
@Service("empService")
public class EmployeeMmtServiceImpl implements IEmployeeMgmtService {
    @Autowired
	private IEmployeeDAO empDao;
	@Override
	public List<Employee> showEmployeeByDesgs(String degs1, String degs2, String degs3) throws Exception {
		List<Employee> list = empDao.getEmployeeByDesgs(degs1, degs2, degs3);
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.4));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
		});
		return list;
	}
	@Override
	public String registerEmployee(Employee emp) throws Exception {
	    
		emp.setJob(emp.getJob().toUpperCase());
		
		int result = empDao.insertEmployee(emp);
		
		return result==0?"Employee register fail":"Employee Register Successfully";
		
	
	}
	@Override
	public String processDelete(Employee emp) throws Exception {
		    int result=empDao.deletEmp(emp);
		    
		return result==0?"Employee Data deleting fail":"Employee data deleteing Successfull";
	}
	@Override
	public String editEmployee(Employee emp) throws Exception 
	{
	   int res= empDao.editEmployeeData(emp);
		return res==0?"Edit Employee Data Fail": "Edit Employee Data SuccessFully";
	}

}
