package com.employeemnmt.empsalary;

public interface EmployeeService  //interface having declarations of all service methods, in order to have loose coupling
{								  //design pattern
	public Employee getEmployee();
	public Employee addEmployee(Employee employee);
	public double calcBonus(Employee employee);
	
}
