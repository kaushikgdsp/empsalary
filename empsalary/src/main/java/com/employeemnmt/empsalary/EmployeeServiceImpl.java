package com.employeemnmt.empsalary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
//	private Employee emp;
	
//	public EmployeeServiceImpl()
//	{
//		emp=new Employee();
//	}
	
	@Autowired
	private Employee emp;
	
	public Employee getEmployee()
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
		
	}
	
	public Employee addEmployee(Employee employee)
	{
		if(employee!=null)
		{
			double bonus=calcBonus(employee);
			employee.setBonus(bonus);
			emp=employee;
			System.out.println("emp in addEmployee "+emp);
			return emp;
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
	
}
