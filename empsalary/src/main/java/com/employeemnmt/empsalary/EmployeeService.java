package com.employeemnmt.empsalary;

public interface EmployeeService 
{
	public Employee getEmployee();
	public Employee addEmployee(Employee employee);
	public double calcBonus(Employee employee);
	
}
