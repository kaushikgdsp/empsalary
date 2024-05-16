package com.employeemnmt.empsalary;

import java.util.List;

public interface EmployeeService 
{
//	public Employee getEmployee();
	public Employee addEmployee(Employee employee);
	public double calcBonus(Employee employee);
	public List<Employee> getAllEmployee();

}
