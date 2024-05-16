package com.employeemnmt.empsalary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
//	private Employee emp;
	private List<Employee> elst;
	
	public EmployeeServiceImpl()
	{
		elst=new ArrayList<>();
	}
	
//	public EmployeeServiceImpl()
//	{
//		emp=new Employee();
//	}
	
	@Autowired
	private Employee emp;
	
/*	public Employee getEmployee()
	{
		if(emp!=null)
		{
			System.out.println("emp in getEmployee "+emp);
			return emp;
		}
		else
		{
			return null;
		}
		
	}		*/
	
	public Employee addEmployee(Employee employee)
	{
		if(employee!=null)
		{
			double bonus=calcBonus(employee);
			employee.setBonus(bonus);
			elst.add(employee);
			System.out.println("employee in addEmployee "+employee);
			return employee;
		}
		else
		{
			
			return null;
		}
		
	}
	
	public double calcBonus(Employee employee)
	{
		if(employee!=null)
		{
			double bonus=employee.getSalary()*0.05;
			bonus=java.lang.Math.abs(bonus);
		
			return bonus;
		}
		else
		{
			return 0.0;
		}
		
	}
	
	public List<Employee> getAllEmployee()
	{
		if(elst!=null)
		{
			if(elst.size()>0)
			{
				System.out.println(elst);
				return elst;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	
}
