package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayRollOperationController;
import com.nt.model.Employee;

@SpringBootApplication
public class IocSpringBootProject05MiniProjectApplication {

	public static void main(String[] args)
	{
	ApplicationContext ctx = SpringApplication.run(IocSpringBootProject05MiniProjectApplication.class, args);
	
	PayRollOperationController bean= ctx.getBean("empController",PayRollOperationController.class);
	
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Enter choice 1 to 4:");
	 int ch=sc.nextInt();
	 
	 switch(ch) {
	 
	 case 1:
	 System.out.println("==================insert employee detail==========================");
	 
	 System.out.println("Enter name ");
	String name= sc.next();
	System.out.println("Enter job ");
	String job= sc.next();
	System.out.println("Enter salary ");
	Double salary= sc.nextDouble();
	System.out.println("Enter DeptNo ");
	int dept= sc.nextInt();
	Employee emp2 = new Employee(name,job,salary,dept);
	try
	{
		String msg=bean.processEmployee(emp2);
		System.out.println(msg);
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	break;
	
	 case 2:
	System.out.println("=====================================Delete Employee Data============================");
	
	System.out.println("Enter Employee Id");
	int id=sc.nextInt();
	Employee emp3=new Employee();
	emp3.setEmpno(id);
	
	try {
		String msg2=bean.deleteEmpData(emp3);
		System.out.println(msg2);
	}catch(Exception e){
		e.printStackTrace();	
	}
	break;
	
	 case 3:
	System.out.println("====================================Featch Employee Data============================");
	
	 System.out.println("enter employee Degignation1");
	 String desg1= sc.next();
	 System.out.println("enter employee Degignation2");
	 String desg2= sc.next();
	 System.out.println("enter employee Degignation3");
	 String desg3= sc.next();
	 
	 try 
	 {
		List<Employee> list = bean.featchEmployeeDesgs(desg1, desg2, desg3);
		list.forEach(emp->{
			System.out.println(emp);
		});
		
	 } 
	 catch (Exception e) 
	 {
		e.printStackTrace();
	 }
	 break;
	 
	 case 4:
	System.out.println("================update Emp data========================= ");
	
	System.out.println("Enter emp name");
	String name2= sc.next();
	System.out.println("Enter emp job");
	String job2= sc.next();
	System.out.println("Enter emp salary");
	Double salary2= sc.nextDouble();
	System.out.println("Enter emp dept");
	Integer dept2= sc.nextInt();
	System.out.println("Enter emp Id");
	Integer id2= sc.nextInt();

	Employee emp4 = new Employee();
	emp4.setEmpname(name2);
	emp4.setJob(job2);
	emp4.setSalary(salary2);
	emp4.setDeptNo(dept2);
	emp4.setEmpno(id2);
	
	
	try
	{
	String msg=	bean.ProcessEmployeeEditing(emp4);
		
	System.out.println(msg);	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	 
	 sc.close();
	 ((ConfigurableApplicationContext) ctx).close();
	}
	
	}

}
