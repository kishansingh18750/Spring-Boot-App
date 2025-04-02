package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOimpl implements IEmployeeDAO {

	
	private static final String GET_EMPS_BY_DESGS ="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";
	private static final String INS_IMP_DETIL="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(EMP_SEQ1.NEXTVAL,?,?,?,?)";
	private static final String DEL_IMP_DATA="DELETE FROM EMP WHERE EMPNO =(?)";
	private static final String EDIT_EMP_DATA="UPDATE EMP SET ENAME =?, JOB=?, SAL=?, DEPTNO=? WHERE EMPNO=?";
	@Autowired
	private DataSource ds;
	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
	
		List<Employee> list = null;
		
		try( //getting pooljdbc con obj
				
				Connection con= ds.getConnection();
				//create prepare statement obj
				
				PreparedStatement ps= con.prepareStatement(GET_EMPS_BY_DESGS);
				
				){
			
			//set value to query parameter
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			try(ResultSet rs= ps.executeQuery())		
			{
			  //process the result set obj
			  list=new ArrayList<Employee>();
			  while(rs.next())
			  {
				  Employee emp=new Employee();
				  emp.setEmpno(rs.getInt("EMPNO"));
				  emp.setEmpname(rs.getString("ENAME"));
				  emp.setJob(rs.getString("JOB"));
				  emp.setSalary(rs.getDouble("SAL"));
				  emp.setDeptNo(rs.getInt("DEPTNO"));
				 
				  //add model object to list collection
				  list.add(emp);
			  }//while
			}//try2
			
		}//try1
		
		catch(SQLException se)
		{
			se.printStackTrace();
			throw se;//Exception rethrowing
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;//Exception rethrowing
		}
		return list;
	}
	
	public int insertEmployee(Employee emp) throws Exception {
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps= con.prepareStatement(INS_IMP_DETIL);
				)
		{
			ps.setString(1, emp.getEmpname());
			ps.setString(2, emp.getJob());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getDeptNo());
			
			int result = ps.executeUpdate();
			return result;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			throw se;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public int deletEmp(Employee emp) throws Exception {
		
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(DEL_IMP_DATA);)
		{
			ps.setInt(1, emp.getEmpno());
			int res=ps.executeUpdate();
			return res;
			
			
		}catch(SQLException se)
		{
			se.printStackTrace();
			throw se;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			
		}

	}

	@Override
	public int editEmployeeData(Employee emp) throws Exception {
		try(Connection con=ds.getConnection();
		PreparedStatement ps= con.prepareStatement(EDIT_EMP_DATA);
				
				){
			
			ps.setString(1, emp.getEmpname());
			ps.setString(2, emp.getJob());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getDeptNo());
			ps.setInt(5, emp.getEmpno());
			
			int res= ps.executeUpdate();
			return res;
		}
			catch(SQLException se)
			{
			  se.printStackTrace();	
			  throw se;
			}
		  catch(Exception e)
		{
			  e.printStackTrace();
			  throw e;
		}
	
	}
	

}
